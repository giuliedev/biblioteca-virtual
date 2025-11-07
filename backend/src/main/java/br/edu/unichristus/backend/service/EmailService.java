package br.edu.unichristus.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.from:noreply@biblioteca-virtual.com}")
    private String remetente;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmailTexto(String destinatario, String assunto, String mensagem) {
        if (destinatario == null || destinatario.isBlank()) {
            logger.warn("Tentativa de enviar email para destinatário vazio ou nulo");
            throw new IllegalArgumentException("O destinatário do email não pode ser vazio");
        }

        if (assunto == null || assunto.isBlank()) {
            logger.warn("Tentativa de enviar email sem assunto");
            throw new IllegalArgumentException("O assunto do email não pode ser vazio");
        }

        try {
            logger.info("Enviando email para: {}", destinatario);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            logger.info("Email enviado com sucesso para: {}", destinatario);
        } catch (Exception e) {
            logger.error("Erro ao enviar email para {}: {}", destinatario, e.getMessage(), e);
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage(), e);
        }
    }
}
