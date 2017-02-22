package study.hard.jjzhu.nio.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransfer {
	private static void catFiles(WritableByteChannel target, String [] files) throws IOException{
		for(String file: files){
			FileInputStream fis = new FileInputStream(file);
			FileChannel channel = fis.getChannel();
			channel.transferTo(0, channel.size(), target);
			channel.close();
			fis.close();
		}
	}
	public static void main(String[] args) throws IOException {
		if(args.length == 0){
			System.err.println("input args");
			return;
		}
		catFiles(Channels.newChannel(System.out), args);
	}
}
