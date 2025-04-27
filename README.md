# gRPC com Java — Estudos e Conceitos (Exemplo prático)

Este repositório foi criado para organizar estudos, exemplos e explanações sobre o uso de gRPC com Java em aplicações modernas de backend.
O que é gRPC?

gRPC (gRPC Remote Procedure Call) é um framework moderno, de código aberto, projetado pelo Google para facilitar a comunicação eficiente entre sistemas distribuídos, especialmente em arquiteturas de microsserviços. Seu principal objetivo é permitir que diferentes serviços — potencialmente escritos em diferentes linguagens — interajam de forma rápida, segura e padronizada.
Características do gRPC

    Alto desempenho: Utiliza o Protocol Buffers (protobuf) para serialização de mensagens em formato binário muito compacto, o que reduz consideravelmente o tamanho dos dados transmitidos e agiliza o processamento.
    Multiplataforma: gRPC suporta diversas linguagens, incluindo Java, Python, C#, Go, Node.js, entre outras.
    Vários modelos de comunicação: gRPC oferece quatro modelos principais:
    Chamada unária (requisição-resposta tradicional)
    Server streaming (servidor envia uma sequência de respostas)
    Client streaming (cliente envia uma sequência de solicitações)
    Bidirectional streaming (comunicação em dois sentidos simultaneamente, como um chat)
    Contrato forte: As APIs são definidas em arquivos .proto (Protocol Buffers), descrevendo claramente os serviços, métodos e mensagens aceitas.
    Eficiente para comunicações internas (service-to-service), especialmente em microsserviços, IoT, mobile, e integrações com baixa latência.

## Diferenças entre gRPC e REST

<table> <thead> <tr> <th>Aspecto</th> <th>REST</th> <th>gRPC</th> </tr> </thead> <tbody> <tr> <td><b>Formato</b></td> <td>Texto (geralmente JSON ou XML)</td> <td>Binário (Protocol Buffers)</td> </tr> <tr> <td><b>Contratos</b></td> <td>Informal, documentação (ex: Swagger)</td> <td>Formal, via arquivos <code>.proto</code></td> </tr> <tr> <td><b>Performance</b></td> <td>Maior overhead por texto e parsing</td> <td>Alta performance por uso binário e HTTP/2</td> </tr> <tr> <td><b>Streaming</b></td> <td>Limitado, não nativo</td> <td>Nativo, bidirecional, eficiente</td> </tr> <tr> <td><b>Versionamento</b></td> <td>Manual, nem sempre padronizado</td> <td>Estruturado via arquivos <code>.proto</code></td> </tr> <tr> <td><b>Comunicação</b></td> <td>Baseado em HTTP/1.1</td> <td>HTTP/2, multiplexação, menor latência</td> </tr> <tr> <td><b>Suporte a linguagens</b></td> <td>Amplo</td> <td>Amplo (+geração automática de client/server)</td> </tr> <tr> <td><b>Utilização</b></td> <td>APIs públicas, sistemas abertos</td> <td>APIs internas, sistemas distribuídos</td> </tr> </tbody> </table>

## Comparativo de desempenho

<table>
  <thead>
    <tr>
      <th>Aspecto</th>
      <th>REST/JSON</th>
      <th>gRPC Unário</th>
      <th>gRPC Streaming</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>HTTP Version</b></td>
      <td>HTTP/1.1</td>
      <td>HTTP/2</td>
      <td>HTTP/2</td>
    </tr>
    <tr>
      <td><b>Execução do Exemplo</b></td>
      <td>
        - 1.000 requisições, 100 concorrentes<br>
        - <b>Tempo total:</b> 86,7s<br>
        - <b>Throughput:</b> 11,5 req/s<br>
        - <b>Maior resposta:</b> 9,5s
      </td>
      <td>
        - 1.000 requisições, 100 concorrentes<br>
        - <b>Tempo total:</b> 36,2s<br>
        - <b>Throughput:</b> 27 req/s<br>
        - <b>Maior resposta:</b> 4,1s
      </td>
      <td>
        - 1.000 requisições, 100 concorrentes<br>
        - <b>Tempo total:</b> 8,2s<br>
        - <b>Throughput:</b> 121 req/s<br>
        - <b>Maior resposta:</b> <1s
      </td>
    </tr>
    <tr>
      <td><b>Conclusão prática</b></td>
      <td>
        Fácil de usar e testar<br>
        Suporte nativo em browsers<br>
        Performance menor em cargas intensivas
      </td>
      <td>
        Mais performático que REST<br>
        Menor latência e maior throughput<br>
        Sem suporte nativo via browser
      </td>
      <td>
        Máxima performance<br>
        Baixa latência mesmo sob alta concorrência<br>
        Indicado para comunicação interna e streaming
      </td>
    </tr>
  </tbody>
</table>
