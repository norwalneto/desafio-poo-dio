package com.projetos;

import com.projetos.dominio.*;

import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Curso Java");
        curso.setDescricao("Descrição do curso Java");
        curso.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria de Java");
        mentoria.setData(java.time.LocalDateTime.now());

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Conteudo conteudo = new Curso();
        conteudo.setTitulo("Curso de Python");
        conteudo.setDescricao("Descrição do curso de Python");
        ((Curso) conteudo).setCargaHoraria(6);

        System.out.println("=== CONTEUDO (POLIMORFISMO) ===");
        System.out.println("Titulo: " + conteudo.getTitulo());
        System.out.println("Descricao: " + conteudo.getDescricao());
        System.out.println("Carga Horaria: " + ((Curso) conteudo).getCargaHoraria());
        System.out.println("XP: " + conteudo.calcularXp());

        System.out.println(curso);
        System.out.println(
                "Mentoria{" +
                        "titulo='" + mentoria.getTitulo() + '\'' +
                        ", descricao='" + mentoria.getDescricao() + '\'' +
                        ", data=" + mentoria.getData().format(formatter) +
                        '}'
        );

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);

        Dev devAlice = new Dev();
        devAlice.setNome("Alice");
        devAlice.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Alice: " + devAlice.getConteudosInscritos());
        devAlice.progredir();
        devAlice.progredir();
        System.out.println("Conteúdos Concluídos Alice: " + devAlice.getConteudosConcluidos());
        System.out.println("XP Total Alice: " + devAlice.calcularTotalXp());


    }
}