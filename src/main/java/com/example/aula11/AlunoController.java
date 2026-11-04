package com.example.aula11;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {
    List<Aluno> alunos = new ArrayList<>();
    public AlunoController() {
        alunos.add(new Aluno("Jose", true, 1));
        alunos.add(new Aluno("Maria", false, 2));
        alunos.add(new Aluno("Pedro", true, 3));
    }

    @GetMapping("/alunos")
    public List<Aluno> buscarTodosAlunos(){
        return alunos;
    }

    @PostMapping("/alunos")
    public void adicionarAluno(@RequestBody Aluno alunoNovo){
        alunos.add(alunoNovo);
    }

    @PutMapping("/alunos")
    public void atualizarAluno(@RequestBody Aluno aluno){ //ESTOU RECEBENDO INFORMAÇÕES NO BODY DA REQUISIÇÃO
        for(Aluno alunoTemp: alunos){
            if(alunoTemp.getMatricula() == aluno.getMatricula()){
                alunoTemp.setPresente(aluno.isPresente());
                alunoTemp.setNome(aluno.getNome());
                return;
            }
        }
    }

    @DeleteMapping("/alunos/{matricula}") //ESTOU RECEBENDO INFORMAÇÕES NA URL DA REQUISIÇÃO
    public void removerAluno(@PathVariable int matricula){
        for(Aluno alunoTemp : alunos){
            if(alunoTemp.getMatricula() == matricula){
                alunos.remove(alunoTemp);
                return;
            }
        }
    }

    @GetMapping("/alunos/pesquisar")
    public List<Aluno> pesquisarAlunosPresentes(@RequestParam boolean presente){
        List<Aluno> presentes = new ArrayList<>();

        for(Aluno alunoTemp : alunos){
            if(alunoTemp.isPresente() == presente){
                presentes.add(alunoTemp);
            }
        }
        return presentes;
    }
}
