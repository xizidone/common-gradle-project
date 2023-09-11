package tech.tongyu.bct.email.version;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class ReadEMLFiles {
    public static void main(String[] args) {
        String emlDirectory = "D:\\AA-xizi\\Desktop\\Last\\广发\\广发\\广发\\广发邮件otc@gf.com.cn\\0807"; // 替换为存储EML文件的目录路径
        String attachmentDir = "D:\\AA-xizi\\Desktop\\Last\\广发\\file"; // 附件保存目录

        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        File emlDir = new File(emlDirectory);
        File[] emlFiles = emlDir.listFiles((dir, name) -> name.endsWith(".eml"));

        if (emlFiles != null) {
            for (File emlFile : emlFiles) {
                processEMLFile(emlFile, attachmentDir, session);
            }
        }
    }

    private static void processEMLFile(File emlFile, String attachmentDir, Session session) {
        try {
            // 打开 EML 文件
            InputStream inputStream = new FileInputStream(emlFile);
            Message emlMessage = new MimeMessage(session, inputStream);

            // 获取发件人
            String sender = ((InternetAddress) emlMessage.getFrom()[0]).getAddress();
            System.out.println("发件人: " + sender);

            // 获取收件人
            Address[] recipients = emlMessage.getAllRecipients();
            System.out.print("收件人: ");
            for (int i = 0; i < recipients.length; i++) {
                System.out.print(((InternetAddress) recipients[i]).getAddress());
                if (i < recipients.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            // 获取收件时间
            String receivedDateHeader = emlMessage.getHeader("Date")[0];
            String receivedDate = parseDate(receivedDateHeader);
            System.out.println("收件时间: " + receivedDate);

            // 遍历邮件中的每一个附件
            Multipart multipart = (Multipart) emlMessage.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                    String filename = bodyPart.getFileName();

                    // 解码附件文件名
                    filename = MimeUtility.decodeText(filename);

                    // 构建附件保存路径
                    String attachmentPath = attachmentDir + File.separator + filename;

                    // 保存附件到指定路径
                    FileOutputStream output = new FileOutputStream(attachmentPath);
                    InputStream input = bodyPart.getInputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    output.close();
                    input.close();

                    System.out.println("附件名称: " + filename);
                    System.out.println("附件下载地址: " + attachmentPath);
                }
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String parseDate(String dateStr) {
        String result = "未知"; // 默认值

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(dateStr);

            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy年M月d日 (E) HH:mm", Locale.getDefault());
            result = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}