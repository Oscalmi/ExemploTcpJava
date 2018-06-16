/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer{
    public static void main(String[] args){
        
        try {
            Scanner input = new Scanner( System.in );
            
            // INICIANDO SERVIDOR
            System.out.print("[ Server: Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            // REALIZANDO CONEXÃO COM CLIENTE
            System.out.print("[ Server: Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            // ESTABELECENDO CANAIS
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            // RECEBENDO MENSAGENS
            byte[] inBuf = new byte[200]; // buffer de recepção
            is.read(inBuf); // Operação bloqueante (aguardando chegada de dados)
            String inMsg = new String(inBuf); // Mapeando vetor de bytes recebido para String
            System.out.println("[ Client: " + inMsg + " ]"); // Imprimindo mensagem recebida na tela
            
            // ENVIANDO MENSAGENS
            System.out.print("[ Server: "); // Solicitando digitação da mensagem
            String outMsg = input.nextLine(); // Lendo mensagem digitada
            byte[] outBuf = outMsg.getBytes(); // Obtendo a respresentação em bytes da mensagem
            os.write(outBuf); // Escrevendo mensagem no canal de saída
            
        }catch(Exception e){System.out.println(e);}
        System.out.println("[ FIM ]");
    }
}