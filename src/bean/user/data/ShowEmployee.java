package bean.user.data;

public class ShowEmployee extends OrganizationElement {

	@Override
	public String show(OrganizationElement oe) {
		StringBuffer sb = new StringBuffer();
		Employee e = (Employee) oe;
		sb.append("<ul><li><span class='employee'><input type='hidden' name='id' value='"+e.getUuid()+"'><i class=\"glyphicon  glyphicon-user\"></i>");
		sb.append(e.getEmployeename().replace(":",""));
		sb.append("</span> <a href=\"\">Goes somewhere</a>");
		sb.append("</li></ul>");
		return sb.toString();
	}
}
