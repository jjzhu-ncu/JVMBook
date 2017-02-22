package study.hard.jjzhu.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelCopy {
	private static void channelCopy1(ReadableByteChannel src, 
			WritableByteChannel dest) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		while(src.read(buffer) != -1){
			buffer.flip();
			dest.write(buffer);
			buffer.compact();
		}
		buffer.flip();
		while(buffer.hasRemaining()){
			dest.write(buffer);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ReadableByteChannel r = Channels.newChannel(System.in);
		WritableByteChannel w = Channels.newChannel(System.out);
		ChannelCopy.channelCopy1(r, w);
		r.close();
		w.close();
	}
}
