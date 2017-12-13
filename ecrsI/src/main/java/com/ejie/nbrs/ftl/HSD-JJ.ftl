<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>王龙</Author>
  <LastAuthor>zlg</LastAuthor>
  <Created>2017-09-11T07:56:38Z</Created>
  <LastSaved>2017-09-22T07:06:02Z</LastSaved>
  <Version>12.00</Version>
 </DocumentProperties>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>9750</WindowHeight>
  <WindowWidth>24000</WindowWidth>
  <WindowTopX>0</WindowTopX>
  <WindowTopY>0</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Center"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s16">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
   <Font ss:FontName="宋体" x:CharSet="134"/>
   <Interior ss:Color="#B3C6E7" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s17">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
   <Borders>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
   <Font ss:FontName="宋体" x:CharSet="134"/>
   <Interior ss:Color="#B3C6E7" ss:Pattern="Solid"/>
  </Style>
  <Style ss:ID="s19">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
  </Style>
  <Style ss:ID="s20">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
  <Style ss:ID="s23">
   <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#FF0000"/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="13" ss:ExpandedRowCount="${list?size + 2}" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5">
   <Column ss:Index="2" ss:AutoFitWidth="0" ss:Width="70.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="94.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="120"/>
   <Column ss:AutoFitWidth="0" ss:Width="84"/>
   <Column ss:AutoFitWidth="0" ss:Width="78"/>
   <Column ss:AutoFitWidth="0" ss:Width="87.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="95.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="92.25"/>
   <Column ss:AutoFitWidth="0" ss:Width="99"/>
   <Column ss:AutoFitWidth="0" ss:Width="94.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="84.75"/>
   <Column ss:AutoFitWidth="0" ss:Width="93.75"/>
   <Row ss:AutoFitHeight="0" ss:Height="37.5">
    <Cell ss:StyleID="s16"><Data ss:Type="String">开始日期</Data></Cell>
    <Cell ss:StyleID="s16"><Data ss:Type="String">结束日期</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">放款渠道</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">业务城市</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">贷款用途</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">进件申请金额</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">进件申请笔数</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">授信通过金额</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">授信通过笔数</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">放款通过金额</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">放款通过笔数</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">放款完成金额</Data></Cell>
    <Cell ss:StyleID="s17"><Data ss:Type="String">放款完成笔数</Data></Cell>
   </Row>
   <#list list as data>
   <Row ss:StyleID="s19">
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.starttime}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.endtime}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.lendingChannel}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.city1}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.loanPurpose1}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.advancePiecePay}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.advancePieceCount}</Data></Cell>
    <Cell ss:StyleID="s23"><Data ss:Type="String">${data.passCreditPpay}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.passCreditCount}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.passLoanPay}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.passLoanCount}</Data></Cell>
    <Cell ss:StyleID="s23"><Data ss:Type="String">${data.finishLoanPay}</Data></Cell>
    <Cell ss:StyleID="s20"><Data ss:Type="String">${data.finishLoanCount}</Data></Cell>
   </Row>
   </#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>600</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>1</ActiveRow>
     <ActiveCol>12</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
