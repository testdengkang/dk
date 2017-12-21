package com.nged.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {



        String server = "127.0.0.1";
        int servPort = 8881;
        byte[] data="hello".getBytes();
        // Create socket that is connected to server on specified port
        Socket socket = new Socket(server, servPort);

        System.out.println("Connected to server...sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // Send the encoded string to the server
        out.write(data);
        //重点代码
        socket.shutdownOutput();
        // Receive the same string back from the server
        // Total bytes received so far
        int totalBytesRcvd = 0;
        // Bytes received in last read
        int bytesRcvd;
     /*   while (totalBytesRcvd < data.length) {
            if ((bytesRcvd = in.read(data, totalBytesRcvd,data.length - totalBytesRcvd)) == -1){
                throw new SocketException("Connection closed prematurely");
            }

            totalBytesRcvd += bytesRcvd;
        }  // data array is full*/

        while((bytesRcvd = in.read())!= -1){
            data[totalBytesRcvd] = (byte)bytesRcvd;
            totalBytesRcvd++;
        }

        System.out.println("Received: " + new String(data));
        out.close();
        socket.close();  // Close the socket and its streams
    }
}
