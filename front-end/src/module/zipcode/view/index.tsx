import { Flex, Text } from "@chakra-ui/react";
import TableZipCodeLog from "@/module/zipcode/components/TableZipCodeLog";
import LayoutView from "@/module/zipcode/components/LayoutView";
import InputSearch from "@/components/InputSearch";
import useZipCode from "@/module/zipcode/hook/useZipCode";
import CardText from "@/components/CardText";

const ZipCodeView: React.FC = () => {
  const {
    zipCode,
    zipCodeLogList,
    searchZipCodeByZipCode,
    searchZipCodeLogsByUf,
  } = useZipCode();

  return (
    <Flex flexDir={"column"} w={"100%"} alignItems={"center"}>
      <LayoutView>
        <Text fontSize="2xl">Buscar Cep</Text>
        <InputSearch onSearch={searchZipCodeByZipCode} />
        {zipCode && (
          <Flex flexWrap={"wrap"} gap={"15px"}>
            <CardText propertie="Cidade" value={zipCode.city} />
            <CardText propertie="Bairro" value={zipCode.neighborhood} />
            <CardText propertie="Logradouro" value={zipCode.street} />
            <CardText propertie="UF" value={zipCode.uf} />
            <CardText propertie="CEP" value={zipCode.zipCode} />
          </Flex>
        )}
      </LayoutView>
      <LayoutView>
        <Text fontSize="2xl">Buscar Log das Consultar por UF</Text>
        <InputSearch onSearch={searchZipCodeLogsByUf} />
        <TableZipCodeLog items={zipCodeLogList} />
      </LayoutView>
    </Flex>
  );
};

export default ZipCodeView;
