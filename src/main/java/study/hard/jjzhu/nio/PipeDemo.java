
package study.hard.jjzhu.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeDemo {
	public static void main(String[] args) throws IOException {
		Pipe pipe = Pipe.open();
		final Pipe.SinkChannel psic= pipe.sink();
		final Pipe.SourceChannel psoc = pipe.source();
		Thread tPwriter = new Thread(){
			@Override
			public void run(){
				try {
					psic.write(ByteBuffer.wrap("hello, pipe".getBytes()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread tPreader = new Thread(){
			@Override
			public void run(){
				int bufferSize = 1024 * 2;
				ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
				try {
					psoc.read(buffer);
					buffer.flip();
					while(buffer.hasRemaining()){
						System.out.print((char)buffer.get());
					}
					buffer.clear();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		tPwriter.start();
		tPreader.start();
	}
}
