package request;

import com.dutt.network.RequestBase;

/**
 * Created by sunpeng on 2017/5/8.
 *
 *
 *
 * VGET /app/class/listGroupPaper.do

 ?trace_uid=3741&groupId=126100&osType=0&token=6f6d68f591a17f4e3a13e12f4f3d2680&version=28&pageSize=10&pcode=010110000&page=1 HTTP/1.1

 */

public abstract class EXueELianBaseRequest extends RequestBase {
    public String osType = "0";
    public String pcode = "010110000";
    public String token = "1b83413c83aa6237d1b6773c29775822";
    public String trace_uid = "3741";
    public String version = "1";
    public String groupId="126100";
    public String  pageSize="10";
    public String page="1";


    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTrace_uid() {
        return trace_uid;
    }

    public void setTrace_uid(String trace_uid) {
        this.trace_uid = trace_uid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "EXueELianBaseRequest{" +
                "osType='" + osType + '\'' +
                ", pcode='" + pcode + '\'' +
                ", token='" + token + '\'' +
                ", trace_uid='" + trace_uid + '\'' +
                ", version='" + version + '\'' +
                ", groupId='" + groupId + '\'' +
                ", pageSize=" + pageSize +
                ", page=" + page +
                '}';
    }
}
