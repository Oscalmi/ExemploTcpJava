/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            Scanner input = new Scanner( System.in );
            
            System.out.print("[ Client: Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            System.out.print("[ Client: ");
            String outMsg = input.nextLine();
            
            byte[] outBuf = outMsg.getBytes(); // Obtendo a respresentação em bytes da mensagem
            os.write(outBuf);

            byte[] inBuf = new byte[200]; // buffer de recepção
            
            is.read(inBuf); // Operação bloqueante (aguardando chegada de dados)
            
            String inMsg = new String(inBuf); // Mapeando vetor de bytes recebido para String
            
            System.out.println("[ Server: " + inMsg + " ]");
            
        }catch(Exception e){System.out.println(e);}
        
        System.out.println("[ FIM ]");
    }
}