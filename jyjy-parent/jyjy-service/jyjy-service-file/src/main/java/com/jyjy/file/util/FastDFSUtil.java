package com.jyjy.file.util;

import com.jyjy.file.pojo.FastDFSFile;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 实现FastDFS文件管理
 * 文件上传
 * 文件下载
 * 文件上传
 * tracker信息获取
 * storage信息获取
 */
public class FastDFSUtil {
    /**
     * 加载tracker链接信息
     */
    static {
        try {
            //查找classpath下的文件路径
            String filename = new ClassPathResource("fdfs_client.conf").getPath();
            //加载tracker链接信息
            ClientGlobal.init(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * @param fastDFSFile:上传的文件信息封装
     */
    public static String[] upload(FastDFSFile fastDFSFile) throws Exception{
//        //附加参数
//        NameValuePair[] meta_list = new NameValuePair[1];
//        meta_list[0] = new NameValuePair("author",fastDFSFile.getAuthor());

        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //获取StorageStorageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        /**
         * 通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的存储信息
         * 1.上传文件的字节数组
         * 2.文件的扩展名 jpg
         * 3.附加参数 比如：拍摄地点:深圳
         *
         * uploads
         *   uploads[0]:文件上传所存储的Storage的组名字 group1
         *   uploads[1]:文件上传到Storage上的文件名字 M00/00/00/1.jpg
         */
        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(),fastDFSFile.getExt(),null);
        return uploads;
    }

    /**
     * 获取文件信息
     * @param groupName:文件的组名
     * @param remoteFileName:文件的存储路径名字
     */
    public static FileInfo getFile(String groupName, String remoteFileName) throws Exception{
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //获取StorageStorageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        //获取文件信息
        return storageClient.get_file_info(groupName,remoteFileName);
    }

    /**
     * 文件下载
     * @param groupName:文件的组名
     * @param remoteFileName:文件的存储路径名字
     */
    public static InputStream downloadFile(String groupName, String remoteFileName) throws Exception {
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //获取StorageStorageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        //文件下载
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);

        return new ByteArrayInputStream(bytes);
    }

    /**
     * 删除文件
     * @param groupName:文件的组名
     * @param remoteFileName:文件的存储路径名字
     */
    public static void deleteFile(String groupName, String remoteFileName) throws Exception {
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //获取StorageStorageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        //删除文件
        storageClient.delete_file(groupName, remoteFileName);

    }

    /**
     * 获取Storage信息
     * @return
     */
    public static StorageServer getStorage() throws Exception{
        //创建TrackerClient对象，通过TrackerClient对象访问TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient获取TrackerServer的链接对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //获取Storage信息
        return trackerClient.getStoreStorage(trackerServer);
    }

    /**
     * 获取Storage的IP和端口信息
     * @param groupName:文件的组名
     * @param remoteFileName:文件的存储路径名字
     * @return
     */
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName) throws Exception{
        //创建TrackerClient对象，通过TrackerClient对象访问TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient获取TrackerServer的链接对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //获取Storage的IP和端口信息
        return trackerClient.getFetchStorages(trackerServer,groupName,remoteFileName);
    }

    /**
     * 获取Tracker信息
     * @return
     */
    public static String getTrackerInfo() throws Exception{
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //获取StorageStorageClient
        StorageClient storageClient = getStorageClient(trackerServer);

        //获取Tracker的IP和Http端口信息
        String ip = trackerServer.getInetSocketAddress().getHostString();
        int tracker_http_port = ClientGlobal.getG_tracker_http_port();
        String url = "http://"+ ip + ":" + tracker_http_port;
        return url;
    }

    /**
     * 获取Tracker
     */
    public static TrackerServer getTrackerServer() throws Exception{
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();

        return trackerServer;
    }

    /**
     * 获取StorageClient
     */
    public static StorageClient getStorageClient(TrackerServer trackerServer) throws Exception{
        //通过TrackerServer获取Storage信息，创建StorageClient对象存储Storage信息
        StorageClient storageClient = new StorageClient(trackerServer,null);
        return storageClient;
    }

    public static void main(String[] args) throws Exception {
        //获取文件信息
        //FileInfo fileInfo = getFile("group1", "M00/00/00/wKjThF6wGqKALvyJAAAzUVi5FPQ462.jpg");
        //System.out.println(fileInfo.getSourceIpAddr());
        //System.out.println(fileInfo.getFileSize());

        //文件下载
        //InputStream is = downloadFile("group1", "M00/00/00/wKjThF6wGqKALvyJAAAzUVi5FPQ462.jpg");
        //将文件写入到本地磁盘
        //FileOutputStream os = new FileOutputStream("D://1.jpg");
        //定义一个缓冲区
        //byte[] buffer = new byte[1024];
        //while (is.read(buffer)!=-1){
        //    os.write(buffer);
        //}
        //os.flush();
        //os.close();
        //is.close();

        //文件删除
        //deleteFile("group1", "M00/00/00/wKjThF6wGqKALvyJAAAzUVi5FPQ462.jpg");

        //获取Storage信息
        //StorageServer storageServer = getStorage();
        //System.out.println(storageServer.getStorePathIndex());
        //System.out.println(storageServer.getInetSocketAddress().getHostString()); //获取IP信息

        //获取Storage的IP和端口信息
        //ServerInfo[] groups = getServerInfo("group1", "M00/00/00/wKjThF1E95SAZkDVAAnAAJuzIB4821.jpg");
        //for (ServerInfo group : groups) {
        //    System.out.println(group.getIpAddr());
        //    System.out.println(group.getPort());
        //}

        //获取Tracker信息
        System.out.println(getTrackerInfo());
    }

}
