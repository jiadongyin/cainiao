package cn.itcast.core.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import cn.itcast.common.utils.StringUtils;

public class SystemLog implements Serializable{

	  private String id;
	  
      private String description;
   
      private String method;
   
      private String logType;
   
      private String requestIp;
  
      private String exceptioncode;
  
      private String exceptionDetail;
  
      private String params;
  
      private String createBy;
  
      private String createDate;
      
      // 日志类型（1：接入日志；2：错误日志）
   	public static final String TYPE_ACCESS = "1";
  	public static final String TYPE_EXCEPTION = "2";
  	public static final String TYPE_INSERT = "5";
  	public static final String TYPE_UPDATE = "6";
  	public static final String TYPE_DELETE = "7";
  	public static final String TYPE_OTHER = "8";
      
      public String getId() {
           return id;
       }
       public void setId(String id) {
          this.id = id == null ? null : id.trim();
       }
   
       public String getDescription() {
           return description;
       }
       public void setDescription(String description) {
           this.description = description == null ? null : description.trim();
       }
   
       public String getMethod() {
           return method;
       }
       public void setMethod(String method) {
           this.method = method == null ? null : method.trim();
       }
   
       public String getLogType() {
           return logType;
       }
       public void setLogType(String logType) {
           this.logType = logType;
       }
   
       public String getRequestIp() {
           return requestIp;
       }
       public void setRequestIp(String requestIp) {
           this.requestIp = requestIp == null ? null : requestIp.trim();
       }
   
       public String getExceptioncode() {
           return exceptioncode;
       }
       public void setExceptioncode(String exceptioncode) {
           this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
       }
   
       public String getExceptionDetail() {
           return exceptionDetail;
       }
       public void setExceptionDetail(String exceptionDetail) {
           this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
       }
   
       public String getParams() {
           return params;
       }
       public void setParams(String params) {
           this.params = params == null ? null : params.trim();
        }
   
       public String getCreateBy() {
           return createBy;
       }
       public void setCreateBy(String createBy) {
           this.createBy = createBy == null ? null : createBy.trim();
       }
   
       public String getCreateDate() {
           return createDate;
       }
       public void setCreateDate(String createDate) {
           this.createDate = createDate;
      }
       
       /**
   	 * 设置请求参数
   	 * @param paramMap
   	 */
   	@SuppressWarnings({ "unchecked", "rawtypes" })
   	public void setParams(Map paramMap){
   		if (paramMap == null){
   			return;
   		}
   		StringBuilder params = new StringBuilder();
   		for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramMap).entrySet()){
   			params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
   			String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
   			params.append(StringUtils.abbr(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue, 100));
   		}
   		this.params = params.toString();
   	}
}
