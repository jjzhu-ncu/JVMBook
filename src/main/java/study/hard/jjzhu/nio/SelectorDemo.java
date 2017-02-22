package study.hard.jjzhu.nio;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {
	public static void main(String[] args) throws IOException {
		Selector selector = SelectorProvider.provider().openSelector();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress("127.0.0.1", 7979));
		SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
		int keysAdded = 0;
		while((keysAdded = selector.select()) > 0){
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iter = readyKeys.iterator();
			while(iter.hasNext()){
				SelectionKey sk = iter.next();
				iter.remove();
				ServerSocketChannel nextRead = (ServerSocketChannel)sk.channel();
				Socket socket = nextRead.accept().socket();
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				String str = dis.readLine();
				while(str != null){
					System.out.println();
					str = dis.readLine();
					
				}
			}
		}
	}
}
