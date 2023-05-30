package servidorpizzaria;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPizzaria {

    public static void main(String[] args) {
        int porta = 8080; // Escolha a porta que deseja utilizar

        try {
            ServerSocket socketServidor = new ServerSocket(porta);
            System.out.println("Servidor iniciado. Aguardando conexões na porta " + porta);

            while (true) {
                Socket socketCliente1 = socketServidor.accept();
                System.out.println("Nova conexão recebida: " + socketCliente1.getInetAddress().getHostAddress());

                InputStream dadosRecebidosCliente1 = socketCliente1.getInputStream();
                OutputStream dadosEnviadosAoCliente1 = socketCliente1.getOutputStream();

                byte[] binarioRecebido = new byte[1024];
                int bytesLidos = dadosRecebidosCliente1.read(binarioRecebido);

                String mensagemConvertidaString = new String(binarioRecebido, 0, bytesLidos);
                System.out.println("Mensagem recebida do cliente: " + mensagemConvertidaString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
