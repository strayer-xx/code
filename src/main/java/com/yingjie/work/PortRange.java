package com.yingjie.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <p>Title: Test</p>
 * <p>Description: </p>
 *
 * 传入端口范围和端口例外，要求使用端口例外将端口范围分割，例如输入端口范围1-100，端口例外50,56，则输出1-49,51-100
 */
public class PortRange {

    public static void main(String[] args) throws IOException {
        int portStart;
        int portEnd;
        int[] portExceptions;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String portRange;
        while (null != (portRange = reader.readLine())) {
            String exclude = reader.readLine();
            String[] ports = portRange.split("-");
            portStart = Integer.parseInt(ports[0]);
            portEnd = Integer.parseInt(ports[1]);
            portExceptions = Arrays.stream(exclude.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            solution(portStart, portEnd, portExceptions);

        }
    }

    public static void solution(int portStart, int portEnd ,int[] portExceptions) {
        // 将例外端口加入列表中
        int[] allPorts = new int[portExceptions.length + 2];
        allPorts[0] = portStart - 1;
        allPorts[allPorts.length - 1] = portEnd + 1;
        System.arraycopy(portExceptions, 0, allPorts, 1, portExceptions.length);
        Arrays.sort(allPorts);

        // 初始化端口范围的起点为1
        int startPort = portStart;

        // 遍历端口例外列表，根据差值来划分端口范围
        for (int port : allPorts) {
            if (port - startPort > 1) {
                System.out.println(startPort + "-" + (port - 1));
            }
            // 更新起点
            startPort = port + 1;
        }

    }
}
