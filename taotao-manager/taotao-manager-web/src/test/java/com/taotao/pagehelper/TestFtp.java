package com.taotao.pagehelper;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFtp {

    @Test
    public void test() throws IOException {
        //创建FtpClient对象
        FTPClient ftpClient = new FTPClient();
        //创建ftp连接,默认21端口
        ftpClient.connect("172.16.0.67", 21);

        //登录ftp服务器,使用用户名密码
        ftpClient.login("qinzi", "123456");
        //设置上传路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/image");
        //上传文件 每次数据连接之前，ftpClient告诉ftpServer开通一个端口来传输数据
        ftpClient.enterLocalPassiveMode();  //注意: 需要在demo的基础上添加这一行,原demo是没有的,加上加好用
        //读取本地文件
        //"C:\Users\john\Pictures\Camera Roll\shan.jpg"
        FileInputStream inputstream = new FileInputStream(new File("C:\\Users\\john\\Pictures\\Camera Roll\\shan.jpg"));
        //修改上传文件格式,不修改导致图片花,使用字节流上传
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//采用二进制传输
        //参数1.remote:上传文件在服务端存储的名字,参数2.local:input流
        ftpClient.storeFile("hello123.jpg",inputstream );
        //关闭连接
        ftpClient.logout();

    }
}
