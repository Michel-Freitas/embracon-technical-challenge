import { Flex } from "@chakra-ui/react";
import { ReactNode } from "react";

type Props = {
  children: ReactNode;
};

const LayoutView: React.FC<Props> = ({ children }) => {
  return (
    <Flex
      w={{ base: "100%", lg: "50%" }}
      justifyContent={"center"}
      flexDir={"column"}
      gap={"10px"}
      p={"10px 20px"}
    >
      {children}
    </Flex>
  );
};

export default LayoutView;
