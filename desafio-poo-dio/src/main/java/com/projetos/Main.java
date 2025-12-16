package com.projetos;

import com.projetos.dominio.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {

        // ==================================================
        // CURSO
        // ==================================================
        Curso curso = new Curso();
        curso.setTitulo("Curso Java");
        curso.setDescricao("Descrição do curso Java");
        curso.setCargaHoraria(8);

        logTitulo("CURSO");
        logCurso(curso);

        // ==================================================
        // MENTORIA
        // ==================================================
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria de Java");
        mentoria.setData(LocalDateTime.now());

        logTitulo("MENTORIA");
        logMentoria(mentoria);

        // ==================================================
        // CONTEÚDO (POLIMORFISMO)
        // ==================================================
        Conteudo conteudo = new Curso();
        conteudo.setTitulo("Curso de Python");
        conteudo.setDescricao("Descrição do curso de Python");
        ((Curso) conteudo).setCargaHoraria(6);

        logTitulo("CONTEÚDO - POLIMORFISMO");
        System.out.println("Título        : " + conteudo.getTitulo());
        System.out.println("Descrição     : " + conteudo.getDescricao());
        System.out.println("Carga Horária : " + ((Curso) conteudo).getCargaHoraria());
        System.out.println("XP            : " + conteudo.calcularXp());

        // ==================================================
        // BOOTCAMP
        // ==================================================
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);

        Dev devAlice = new Dev();
        devAlice.setNome("Alice");
        devAlice.inscreverBootcamp(bootcamp);

        logTitulo("DEV - ALICE");
        System.out.println("Conteúdos Inscritos : " + devAlice.getConteudosInscritos());

        devAlice.progredir();
        devAlice.progredir();

        System.out.println("Conteúdos Concluídos: " + devAlice.getConteudosConcluidos());
        System.out.println("XP Total           : " + devAlice.calcularTotalXp());
    }

    // ==================================================
    // MÉTODOS DE LOG (VISUAL, NÃO DOMÍNIO)
    // ==================================================
    private static void logTitulo(String titulo) {
        System.out.println();
        System.out.println("==============================================");
        System.out.println(" " + titulo);
        System.out.println("==============================================");
    }

    private static void logCurso(Curso curso) {
        System.out.println("Título        : " + curso.getTitulo());
        System.out.println("Descrição     : " + curso.getDescricao());
        System.out.println("Carga Horária : " + curso.getCargaHoraria());
        System.out.println("XP            : " + curso.calcularXp());
    }

    private static void logMentoria(Mentoria mentoria) {
        System.out.println("Título        : " + mentoria.getTitulo());
        System.out.println("Descrição     : " + mentoria.getDescricao());
        System.out.println("Data          : " + mentoria.getData().format(FORMATTER));
    }
}