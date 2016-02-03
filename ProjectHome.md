Poucos trabalhos têm investigado a influência de se utilizar informações sobre a história de evolução dos módulos em estratégias de detecção. Uma das razões disso é a falta de suporte adequado para tais pesquisas. Essa ferramenta, dentre outros recursos, permite a especificação e avaliação de diferentes configurações de estratégias de detecção por meio de linguagem específica de domínio (DSL). A Hist-Inspect viabiliza avaliações empíricas de estratégias convencionais e sensíveis à história e também disponibiliza a desenvolvedores um ambiente flexível para a definição e aplicação dessas estratégias. Gráficos de evolução e métricas sensíveis à história também são disponibilizados.

# Introdução #

Essa página apresenta a ferramenta Hist-Inspect que, além de suportar a apresentação de gráficos de evolução e de métricas sensíveis à história, como principal contribuição possibilita a especificação de diferentes estratégias de detecção através de uma linguagem específica de domínio (DSL). Tal flexibilidade atende necessidades de dois grupos de usuários: desenvolvedores interessados em ajustar valores limites ou
combinação de métricas para a detecção de anomalias; e pesquisadores interessados na
avaliação e comparação da eficácia de diferentes estratégias, sejam elas convencionais ou
sensíveis à história.


# Detalhes #

## Suporte a Gráficos de Evolução ##
Ao se pensar em análise sensível à história, faz-se necessário a observação de dados históricos que revelam o comportamento evolutivo do sistema durante seu ciclo de vida. Por meio de gráficos, o avaliador pode perceber a estabilidade, o crescimento ou decrescimento de uma dada propriedade (por exemplo, linhas de código), sem ter que exatamente recuperar o valor dessa propriedade em cada versão do módulo avaliado. Além disso, torna-se interessante poder visualizar o comportamento de mais de uma métrica ao longo da história de um módulo, possiblitando, inclusive, a descoberta de padrões de influência que uma propriedade teve sobre a outra. A ferramenta proposta disponibiliza tal funcionalidade e para implementá-la foi utilizada a biblioteca gráfica JFreeChart.

![http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_mw8rZuI/AAAAAAAAARE/W76eBcKDte8/s800/HistInspect2Grafico.png](http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_mw8rZuI/AAAAAAAAARE/W76eBcKDte8/s800/HistInspect2Grafico.png)

## Suporte a Detecção de Anomalias através de Estratégias de Detecção ##
Uma estratégia de detecção é uma condição lógica composta por métricas e respectivos valores limites que detecta elementos com anomalias de modularidade (ou,  _code smells_). Seu grande benefício é que o desenvolvedor pode localizar diretamente classes e métodos afetados por uma dada anomalia, em vez de ter que inferir o problema a partir de um extenso conjunto de valores anormais de métricas. Um requisito fundamental para pesquisas relacionadas a tal mecanismo, é o suporte adequado de ferramentas que automatizem tais estratégias. A Hist-Inpect automatiza a especificação e aplicação tanto de estratégias convencionais quanto de estratégias sensíveis à história.

![http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_uPvfX-I/AAAAAAAAARc/qRNPe1qdBY0/s640/RelatorioDeteccoesNoFirefox.png](http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_uPvfX-I/AAAAAAAAARc/qRNPe1qdBY0/s640/RelatorioDeteccoesNoFirefox.png)

## Suporte a Métricas Sensíveis à História ##
Métricas sensíveis à história (SHs) consideram a avaliação das características dos módulos ao longo do seu histórico de evolução. Em sua grande maioria elas medem a evolução de métricas convencionais como as de complexidade, coesão, dentre outras. A implementação dessas métricas foi motivada pela necessidade de viabilizar a criação e aplicação de estratégias de detecção sensíveis à história. Através do cálculo dessas métricas é possível obter informações como: a quatidade de vezes que um dado módulo sofreu aumento de linhas de código ao longo de sua história (rniLOC), a variação média de linhas de código em cada versão (rdocLOC), o aumento percentual da complexidade de um módulo em relação a sua versão anterior (rpiWMPC1), e assim por diante. Todas foram originalmente propostas no contexto dessa pesquisa e disponibilizadas pela Hist-Inspect.

**Auto-Complete na Solicitação de Apresentação das Métricas**

![http://lh4.ggpht.com/_P1kXrtn0WgE/TCp_mIbJapI/AAAAAAAAAQ4/LfSzHUW18ZU/s800/AutoCompleteMetricView.png](http://lh4.ggpht.com/_P1kXrtn0WgE/TCp_mIbJapI/AAAAAAAAAQ4/LfSzHUW18ZU/s800/AutoCompleteMetricView.png)

**Hide-Show das Métricas Apresentadas**

![http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_mDT6lCI/AAAAAAAAAQ8/mFOQe6NzAmc/s800/HideAndShowMetric.png](http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_mDT6lCI/AAAAAAAAAQ8/mFOQe6NzAmc/s800/HideAndShowMetric.png)

**Apresentação de Métricas**

![http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_m25bBSI/AAAAAAAAARI/fUWlDomi9Ao/MetricasSH.png](http://lh5.ggpht.com/_P1kXrtn0WgE/TCp_m25bBSI/AAAAAAAAARI/fUWlDomi9Ao/MetricasSH.png)

## Exemplo de Catálogo XML de Anomalias ##
![http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_ccHGKXI/AAAAAAAAAQs/SVfzH3rCquI/AnomaliesXML.png](http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_ccHGKXI/AAAAAAAAAQs/SVfzH3rCquI/AnomaliesXML.png)


## Exemplo de Catálogo XML de Estratégias ##
![http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_zI_L_6I/AAAAAAAAARg/J4SXFjYUN-s/Rules.XML.png](http://lh6.ggpht.com/_P1kXrtn0WgE/TCp_zI_L_6I/AAAAAAAAARg/J4SXFjYUN-s/Rules.XML.png)
