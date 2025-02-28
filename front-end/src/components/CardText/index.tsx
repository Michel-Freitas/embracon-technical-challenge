import { Flex, Text } from "@chakra-ui/react";

type Props = {
  propertie: string;
  value: string;
};

const CardText: React.FC<Props> = ({ propertie, value }) => {
  return (
    <Flex gap={"4px"}>
      <Text fontWeight={"bold"}>{propertie}: </Text>
      <Text>{value}</Text>
    </Flex>
  );
};

export default CardText;
