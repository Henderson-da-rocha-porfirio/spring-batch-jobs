# spring-batch-jobs
> Exemplo básico sobre o funcionamento de um job
>
## Job:
> - Coleção de estados e transições de um para o outro definidas por steps, ou seja, ele se comporta como uma máquina de estados.
>
> - Job possui três steps(step 1, step 2 e step 3) que possuem uma lógica interna de leitura(ItemReader), processamento(ItemProcessor) e escrita(ItemWriter).

## Componentes do Job:
> - JobLauncher: responsável pela execução do Job.
>
> - JobRepository: mantém os metadados do spring batch salvos.
>
> - JobInstance: Execução da lógica do Job do início ao fim até obter sucesso.
>
> - JobExecution: Execução física.
>
> - Contudo, o que define a criação de um JobInstance sao os parâmetros de execução(Job).
