package com.manulife.springbatch;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public  class SpringbatchApplicationTests {
	private static final Logger logger =  LogManager.getLogger(SpringbatchApplicationTests.class);
/*	@Test
	public void contextLoads() {
		StopWatch sw = new StopWatch();
		sw.start();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream("D:\\4444444.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			inputStream = new FileInputStream("D:\\555555.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			inputStream = new FileInputStream("D:\\666666.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			inputStream = new FileInputStream("D:\\7777777.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			inputStream = new FileInputStream("D:\\888888.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			inputStream = new FileInputStream("D:\\999999.csv");
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				logger.info(line);
			}
			sw.stop();
			System.out.println("总共执行时间:"+sw.getTotalTimeMillis());	 //总执行时间
		}catch(Exception e){
	     logger.error(e.getMessage());

		}finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}
	}*/

/*	@Test
	public  void test2(){
		StopWatch sw = new StopWatch();
		sw.start();
		LineIterator it=null;
		try {

			it = FileUtils.lineIterator(new File("D:\\4444444.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			LineIterator.closeQuietly(it);
			it = FileUtils.lineIterator(new File("D:\\555555.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			LineIterator.closeQuietly(it);
			it = FileUtils.lineIterator(new File("D:\\666666.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			LineIterator.closeQuietly(it);
			it = FileUtils.lineIterator(new File("D:\\7777777.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			LineIterator.closeQuietly(it);
			it = FileUtils.lineIterator(new File("D:\\888888.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			LineIterator.closeQuietly(it);
			it = FileUtils.lineIterator(new File("D:\\999999.csv"), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				logger.info(line);
				// do something with line
			}
			sw.stop();
			System.out.println("总共执行时间:"+sw.getTotalTimeMillis());	 //总执行时间
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			LineIterator.closeQuietly(it);

		}
	}*/




}
