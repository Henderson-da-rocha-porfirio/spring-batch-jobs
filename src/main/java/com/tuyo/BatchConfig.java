package com.tuyo;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.scope.context.*;
import org.springframework.batch.core.step.tasklet.*;
import org.springframework.batch.repeat.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

/* 1. Job: tarefa que vai encapsular a rotina da batch.
 *  2. Builders: Cria job.
 *  3. A lógica dentro de um job é dividida em etapas que são chamadas de 'step'. Como ex. temos alí o 'start'.
 *  4. Build: constrói o job.
 *  5. tasklets: é o tipo do step. Muito usado para pequenas tarefas para pequenos programas que não
 * requerem muito processamento de dados.
 *  6. Tasklet: é uma interface.
 *  7. .build(): constrói o step.
 *  8. @Bean: informar que o objeto existe (nao esquecer)
 *  9. @EnableBatchProcessing: importar todas as features da framework. */

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job imprimeOlaJob() {
        return jobBuilderFactory
                .get("imprimeOlaJob")
                .start(imprimeOlaStep())
                .build();

    }

    private Step imprimeOlaStep() {
        return stepBuilderFactory
                .get("imprimeOlaStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Olá, mundo!");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

}
