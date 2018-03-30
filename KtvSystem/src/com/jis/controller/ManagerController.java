package com.jis.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jis.bean.Language;
import com.jis.form.AddGoodsInfo;
import com.jis.form.AddSongInfoForm;
import com.jis.form.UpdateSongForm;
import com.jis.pojo.AddPrice;
import com.jis.pojo.Customer;
import com.jis.pojo.Employee;
import com.jis.pojo.Goods;
import com.jis.pojo.GoodsType;
import com.jis.pojo.RoomType;
import com.jis.pojo.Song;
import com.jis.pojo.StyleType;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.Vip;
import com.jis.service.ManagerService;
import com.jis.util.Token;

/**
 * 管理员控制器
 * @author shu
 *
 */
@Controller
public class ManagerController {
	@Autowired
	private ManagerService manager;
	/**
	 * 根据语种筛选歌曲(分页显示)
	 * @param language
	 * @return
	 */
	@RequestMapping("findSongByLanguage")
	public String findSongByLanguage(String language,int pageCode){
		List<Song> songList=null; 
		//总歌曲数
		int totlePage=1;
		//总页码数
		int sumPage=1;
		if(language.equals("全部")){
			songList=manager.findSongByPageCode(pageCode);
			totlePage=manager.findCount();
		}
		else{
			songList=manager.findSongByLanguage(language,pageCode);
			totlePage=manager.findCountByLanguage(language);
		}
		List<Language> languageList=manager.findAllLanguage();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("songList", songList);
		request.setAttribute("languageList", languageList);
		if(totlePage%10==0){
			sumPage=totlePage/10;
		}else{
			sumPage=totlePage/10+1;
		}
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("language", language);
		request.setAttribute("currentPage", pageCode);
		return "page/ajax/manageMusic"; 
	}
	/**
	 * 实时搜索呈现结果(模糊匹配)
	 * @param input
	 * @return
	 */
	@ResponseBody
	@RequestMapping("searchMusic")
	public List<Song> searchMusic(String input){
		List<Song> songList=manager.findSongBySearch("%"+input+"%");
		return songList;
	}
	/**
	 * 根据歌名查询歌曲
	 * @param songName
	 * @return
	 */
	@RequestMapping("searchByName")
	public String searchByName(String songName){
		List<Song> songList=manager.findSongBySongName(songName);		
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();		
		request.setAttribute("songList", songList);
		request.setAttribute("sumPage", 1);
		return "page/ajax/searchResult";
	}
	/**
	 * 点击搜索去查询歌曲
	 * @param searchInput
	 * @return
	 */
	@RequestMapping("searchInput")
	public String searchInput(String searchInput,int pageCode){		
		List<Song> songList1=manager.findSongBySearch("%"+searchInput+"%");
		//总歌曲数
		int totlePage=songList1.size();
		//总页码数
		int sumPage=1;
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		if(totlePage%10==0){
			sumPage=totlePage/10;
		}else{
			sumPage=totlePage/10+1;
		}
		List<Song> songList=new ArrayList<>();
		int index=0;
		if(10*pageCode>=totlePage){
			index=totlePage;
		}else{
			index=10*pageCode;
		}
		for(int i=(10*pageCode-10);i<index;i++){
			songList.add(songList1.get(i));
		}
		request.setAttribute("songList", songList);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("currentPage", pageCode);
		request.setAttribute("searchInput", searchInput);
		return "page/ajax/searchResult";
	}
	/**
	 * 根据歌曲编号删除歌曲
	 * @param songId
	 * @return
	 */
	@RequestMapping("deleteSong")
	public String deleteSong(int songId){
		manager.deleteSongBySongId(songId);
		return "page/admin";
	}
	/**
	 * 根据歌曲编号查找歌曲显示再更新页面
	 * @param songId
	 * @return
	 */
	@RequestMapping("updateSong")
	public String updateSong(int songId){
		Song song=manager.findSongBySongId(songId);
		List<StyleType> styleList=manager.findTyleBySongId(songId);
		List<StyleType> allStyleList=manager.findAllStyle();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("song", song);
		request.setAttribute("styleList", styleList);
		request.setAttribute("allStyleList", allStyleList);
		return "page/ajax/updateSong";
	}
	/**
	 * 更新歌曲内容
	 * @return
	 */
	@RequestMapping("updateSongInfo")
	public String updateSongInfo(UpdateSongForm form){
		manager.updateSongBySongId(form);
		return "page/admin";
	}
	/**
	 * 播放歌曲
	 * @param songPath
	 * @return
	 */
	@RequestMapping("playSong")
	public String playSong(String songPath){
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("songPath", songPath);
		return "page/ajax/playSong";
	}
	/**
	 * 更新歌曲的风格类型
	 * @param songId
	 * @param styleArray
	 * @return
	 */
	@RequestMapping("updateStyle")
	public String updateStyle(int songId,int styleId){
		manager.addSongStyleBySongId(songId, styleId);
		return "";
	}
	/**
	 * 删除歌曲风格
	 * @param songId
	 * @return
	 */
	@RequestMapping("deleteSongToType")
	public String deleteSongToType(int songId){
		manager.deleteSongToTypeBySongId(songId);
		return "";
	}
	/**
	 * 添加歌曲初始页面
	 * @return
	 */
	@RequestMapping("addSong")
	public String addSong(){
		List<Language> languageList=manager.findAllLanguage();
		List<StyleType> allStyleList=manager.findAllStyle();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("languageList", languageList);	
		request.setAttribute("allStyleList", allStyleList);
		return "page/ajax/addSong";
	}
	/**
	 * 歌曲上传
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "uploadSong", method = RequestMethod.POST)
    public @ResponseBody
    String uploadSong(HttpServletRequest request,
                  HttpServletResponse response, ModelMap model,HttpSession session) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile = multipartRequest.getFile("song");
        String path="H:\\毕业设计\\KTVworkspace\\KtvSystem\\WebContent\\video\\";
        String filename = mFile.getOriginalFilename();
        System.out.println("filename:"+filename);
        InputStream inputStream = mFile.getInputStream();
        byte[] b = new byte[1048576];
        int length = inputStream.read(b);
        String url =path + filename;
        System.out.println(url);
        FileOutputStream outputStream = new FileOutputStream(url);
        outputStream.write(b, 0, length);
        inputStream.close();
        outputStream.close();
        return filename;
    }
	/**
	 * 添加歌曲信息到歌曲表
	 * @param addSongForm
	 * @return
	 */
	@RequestMapping("addSongInfo")
	public String addSongInfo(AddSongInfoForm addSongForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String token=addSongForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		if(addSongForm!=null&&serverToken!=null&&serverToken.toString().equals(token)){
		manager.addSong(addSongForm);
		System.out.println(addSongForm.getSongPath());
		Song song=manager.findSongBySongPath(addSongForm.getSongPath());
		for(int i=0;i<addSongForm.getSongStyle().length;i++){
			manager.addSongStyleBySongId(song.getSongId(), Integer.parseInt(addSongForm.getSongStyle()[i]));
		}
		
		}	
		return "page/admin";
	}
	/**
	 * 进入商品管理中心
	 * @return
	 */
	@RequestMapping("manageGoods")
	public String manageGoods(int goodsTypeId,int pageCode){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<GoodsType> goodTypeList=manager.findGoodsTypes();
		List<Goods> goodsList=null;
		//总条目数
		int tatalItems=0;
		//总页码数
		int sumPage=1;
		if(goodsTypeId==0){
			goodsList=manager.findAllGoods(pageCode);
			tatalItems=manager.findAllGoodsCount();
		}else{
			goodsList=manager.findGoodsByTypeId(goodsTypeId, pageCode);
			tatalItems=manager.findGoodsCountByTypeId(goodsTypeId);
		}	
		if(tatalItems%10==0){
			sumPage=tatalItems/10;
		}else{
			sumPage=tatalItems/10+1;
		}
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("currentPage", pageCode);
		request.setAttribute("goodstypeId", goodsTypeId);
		request.setAttribute("goodTypeList", goodTypeList);
		request.setAttribute("goodsList", goodsList);
		return "page/ajax/manageGoods";
	}
	/**
	 * 查询商品
	 * @param searchContent
	 * @param goodsTypeId
	 * @param pageCode
	 * @return
	 */
	@RequestMapping("searchGoods")
	public String searchGoods(String searchContent){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Goods> goodsList=manager.searchGoods("%"+searchContent+"%");
		request.setAttribute("goodsList", goodsList);
		return "page/ajax/searchGoods";
	}
	/**
	 * 包厢类型管理初始加载页面
	 * @return
	 */
	@RequestMapping("manageRoom")
	public String manageRoom(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<RoomType> roomTypeList=manager.findAllRoomType();
		request.setAttribute("roomTypeList", roomTypeList);
		return "page/ajax/roomTypeManage";
	}
	/**
	 * 修改包厢类型名
	 * @param roomTypeName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateRoomType")
	public String updateRoomType(String roomTypeName,int roomTypeId,String roomTypeFee){
		if(roomTypeFee==null){
			manager.updateRoomTypeById(roomTypeName, 0, roomTypeId);
		}else{
			manager.updateRoomTypeById(roomTypeName, Integer.parseInt(roomTypeFee), roomTypeId);
		}
		return "";
	}
	/**
	 * 初始化包厢加价折扣信息
	 * @return
	 */
	@RequestMapping("manageRoomDis")
	public String manageRoomDis(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<AddPrice> addPriceList=manager.getAllDiscount();
		System.out.println(addPriceList.size());
		request.setAttribute("addPriceList", addPriceList);
		return "page/ajax/roomTypeDis";
	}
	/**
	 * 更新加价折扣
	 * @param RoomDis
	 * @param roomTypeId
	 * @param timeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateRoomDis")
	public String updateRoomDis(float RoomDis,int roomTypeId,int timeId){
		manager.updateDiscountFeeByTimeId(RoomDis, roomTypeId, timeId);
		return "";
	}
	/**
	 * 上传商品图片
	 * @param imgPath
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request,
                  HttpServletResponse response, ModelMap model,HttpSession session) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile = multipartRequest.getFile("goodsImg");
        String path="H:\\毕业设计\\KTVworkspace\\KtvSystem\\WebContent\\images\\goodsImgs\\";
        String filename = mFile.getOriginalFilename();
        System.out.println("filename:"+filename);
        InputStream inputStream = mFile.getInputStream();
        byte[] b = new byte[1048576];
        int length = inputStream.read(b);
        String url =path + filename;
        System.out.println(url);
        FileOutputStream outputStream = new FileOutputStream(url);
        outputStream.write(b, 0, length);
        inputStream.close();
        outputStream.close();
        return filename;
    }
	/**
	 * 添加商品
	 * @param addGoodsInfo
	 * @return
	 */
	@RequestMapping("addGoods")
	public String addGoods(AddGoodsInfo addGoodsInfo){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String token=addGoodsInfo.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		if(addGoodsInfo!=null&&serverToken!=null&&serverToken.toString().equals(token)){
		manager.addGoods(addGoodsInfo);
		}
		return "page/admin";
	}
	/**
	 * 删除商品
	 * @param goodsId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteGoods")
	public String deleteGoods(String goodsId){
		if(goodsId!=null){
			manager.deleteGoods(Integer.parseInt(goodsId));
			return "1";
		}
		return "";
	}
	/**
	 * 添加商品分类
	 * @param GoodstypeName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addGoodsType")
	public String addGoodsType(String GoodstypeName){
		manager.addGoodsType(GoodstypeName);
		return "";
	}
	@ResponseBody
	@RequestMapping("delGoodsType")
	public String delGoodsType(String GoodstypeId){
		if(GoodstypeId!=""){
			manager.deleteGoodsType(Integer.parseInt(GoodstypeId));
		}
		return "";
	}
	/**
	 * 更新商品信息
	 * @param goodsId
	 * @param updateCon
	 * @param flag
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateGoodsInfo")
	public String updateGoodsInfo(int goodsId,String updateCon,String flag){
		if("goodsName".equals(flag)){
			manager.updateGoodsInfo(goodsId, updateCon, 0, 0, 0);
		}
		if("goodsPrice".equals(flag)){
			manager.updateGoodsInfo(goodsId, null, Float.parseFloat(updateCon), 0, 1);
		}
		if("goodsCount".equals(flag)){
			manager.updateGoodsInfo(goodsId, null, 0, Integer.parseInt(updateCon), 2);
		}
		return "";
	}
	/**
	 * 初始化vip用户界面
	 * @return
	 */
	@RequestMapping("vipUsers")
	public String vipUsers(int pageCode){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Vip> vipList1=manager.findAllVip();
		//总条目数
		int tatalItems=vipList1.size();
		//总页码数
		int sumPage=1;
		if(tatalItems%10==0){
			sumPage=tatalItems/10;
		}else{
			sumPage=tatalItems/10+1;
		}
		List<Vip> vipList=new ArrayList<>();
		int index=0;
		if(10*pageCode>=tatalItems){
			index=tatalItems;
		}else{
			index=10*pageCode;
		}
		for(int i=(10*pageCode-10);i<index;i++){
			vipList.add(vipList1.get(i));
		}
		req.setAttribute("sumPage", sumPage);
		req.setAttribute("currentPage", pageCode);
		req.setAttribute("vipList", vipList);
		return "page/ajax/vipUsers";
	}
	/**
	 * 更新vip用户
	 * @return
	 */
	@RequestMapping("updateVip")
	public String updateVip(){
		return "page/ajax/updateVip";
	}
	/**
	 * 删除vip用户
	 * @param vipId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteVip")
	public String deleteVip(int vipId){
		manager.deleteVipById(vipId);
		return "";
	}
	/**
	 * 普通用户初始化
	 * @param pageCode
	 * @return
	 */
	@RequestMapping("commonUser")
	public String commonUser(int pageCode){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Customer> CustomerList1=manager.findAllCustomer();
		//总条目数
		int tatalItems=CustomerList1.size();
		//总页码数
		int sumPage=1;
		if(tatalItems%10==0){
			sumPage=tatalItems/10;
		}else{
			sumPage=tatalItems/10+1;
		}
		List<Customer> CustomerList=new ArrayList<>();
		int index=0;
		if(10*pageCode>=tatalItems){
			index=tatalItems;
		}else{
			index=10*pageCode;
		}
		for(int i=(10*pageCode-10);i<index;i++){
			CustomerList.add(CustomerList1.get(i));
		}
		req.setAttribute("sumPage", sumPage);
		req.setAttribute("currentPage", pageCode);
		req.setAttribute("CustomerList", CustomerList);
		return "page/ajax/commonUsers";
	}
	/**
	 * 根据顾客的编号删除用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteUser")
	public String deleteUser(int userId){
		manager.deleteCustomerById(userId);
		return "";
	}
	/**
	 * 初始化员工
	 * @param pageCode
	 * @return
	 */
	@RequestMapping("manageEmp")
	public String manageEmp(int pageCode){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Employee> EmpList1=manager.findAllEmp();
		//总条目数
		int tatalItems=EmpList1.size();
		//总页码数
		int sumPage=1;
		if(tatalItems%10==0){
			sumPage=tatalItems/10;
		}else{
			sumPage=tatalItems/10+1;
		}
		List<Employee> EmpList=new ArrayList<>();
		int index=0;
		if(10*pageCode>=tatalItems){
			index=tatalItems;
		}else{
			index=10*pageCode;
		}
		for(int i=(10*pageCode-10);i<index;i++){
			EmpList.add(EmpList1.get(i));
		}
		req.setAttribute("sumPage", sumPage);
		req.setAttribute("currentPage", pageCode);
		req.setAttribute("EmpList", EmpList);
		return "page/ajax/manageEmp";
	}
	/**
	 * 根据员工编号删除员工
	 * @param empId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteEmp")
	public String deleteEmp(int empId){
		manager.deleteEmpByempId(empId);
		return "";
	}
	/**
	 * 查找员工姓名
	 * @param searchContent
	 * @return
	 */
	@RequestMapping("searchEmps")
	public String searchEmps(String searchContent){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<Employee> EmpList=manager.searchEmp("%"+searchContent+"%");
		req.setAttribute("EmpList", EmpList);
		return "page/ajax/searchEmp";
	}
	/**
	 * 进入员工的个人主页
	 * @return
	 */
	@RequestMapping("intoPerson")
	public String intoPerson(){
		return "page/ajax/empPersonal";
	}
	/**
	 * 进入消息通知页面
	 * @return
	 */
	@RequestMapping("systemInfo")
	public String systemInfo(){
		return "page/ajax/systemInfo";
	}
	/**
	 * 校验号码的有效性
	 * @param relativeTel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("testRelativeTel")
	public String testRelativeTel(String relativeTel){
		Vip vip=manager.findVipByVipTel(relativeTel);
		Employee employee=manager.findEmpByEmpTel(relativeTel);
		if(vip==null&&employee==null){
			return "该号码无效！";
		}
		return "";
	}
	/**
	 * 消息通知
	 * @param titleContent
	 * @param relative
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addSystemInfo")
	public String addSystemInfo(String titleContent,String relative,String content){
		SystemInfo systemInfo=null;
		if(relative.length()>1){
			systemInfo=new SystemInfo(titleContent, content,new Date() , 100, relative);			
		}
		else{
			systemInfo=new SystemInfo(titleContent, content,new Date() , Integer.parseInt(relative),"tel" );			
		}
		manager.addSystemInfo(systemInfo);
		return "";
	}
}
