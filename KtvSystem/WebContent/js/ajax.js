
function doAjax(id,url)
{
	//����xmlhttp����
	var xmlhttp=null;
	//IE7.0�����ϰ汾��FIREFOX�������
	if(window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	//IE6.0��֮ǰ��IE�汾
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//ʱ���
	var index=url.indexOf("?");
	if(index!=-1)
	{
		url+="&";
	}
	else
	{
		url+="?";
	}
	url+="time="+new Date().getTime();
	
	
	//���첽���� ��һ���������ύ�ķ�ʽ �ڶ���������ʾ�ύ��URL ������������ʾ�Ƿ����첽��ʽ����
	xmlhttp.open("get", url, true);
	//��������
	xmlhttp.send(null);
	
	//�첽������Ӧ״̬�¼�
	xmlhttp.onreadystatechange=function()
	{
		//��������ѱ�������Ӧ���
		if(xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			var div=document.getElementById(id);
			//alert(xmlhttp.responseText);
			//��xmlhttp��������õ��Ľ��������ҳ����
			div.innerHTML=xmlhttp.responseText;
		}
	}
	
//	xmlHttp.readyState		  
//	0: ����δ��ʼ�� 
//	1: �����������ѽ��� 
//	2: �����ѽ��� 
//	3: �������� 
//	4: ��������ɣ�����Ӧ�Ѿ��� 

//	xmlHttp.states
//	200: "OK"
//	404: δ�ҵ�ҳ��
	
	//alert("success");
	
}
