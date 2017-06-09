package compsg.cn.msgboard.bean;

import java.sql.Date;
import java.util.List;

//Users表的实体类
public class Users {

    //用户id
    private int userId;
    //用户名（登录名）
    private String userName;
    //昵称
    private String userNickName;
    //密码
    private String userPassword;
    //生日
    private Date userBirthday;
    //手机号
    private String userMobile;
    //邮箱地址
    private String userMail;
    //留言列表
    private List<Messages> messagesList;

    public Users() {
        super();
    }
    public Users(String userName, String userNickName,
                 String userPassword, Date userBirthday, String userMobile,
                 String userMail) {
        super();
        this.userName = userName;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
        this.userBirthday = userBirthday;
        this.userMobile = userMobile;
        this.userMail = userMail;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserNickName() {
        return userNickName;
    }
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public Date getUserBirthday() {
        return userBirthday;
    }
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
    public String getUserMobile() {
        return userMobile;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public List<Messages> getMessagesList() {
        return messagesList;
    }
    public void setMessagesList(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

}