import { ChakraProvider } from "@chakra-ui/react";
import { ReactNode } from "react";

type Props = {
  children: ReactNode;
};

const Provider = ({ children }: Props) => {
  return <ChakraProvider>{children}</ChakraProvider>;
};

export default Provider;
