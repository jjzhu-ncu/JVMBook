package study.hard.jjzhu.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelDemo {
	
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile rFile = new RandomAccessFile("./a.txt", "rw");
		FileChannel channel = rFile.getChannel();
		
		
		RandomAccessFile tFile = new RandomAccessFile("./b.txt", "rw");
		FileChannel tChannel = tFile.getChannel();
		tChannel.transferFrom(channel, 0, channel.size());
		
		
		
		/*ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buf);
		while(bytesRead != -1){
			System.out.println("Read " + bytesRead);
			buf.flip();//读准备
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			buf.clear();
			bytesRead = channel.read(buf);
		}*/
		rFile.close();
		tFile.close();
	}
}
