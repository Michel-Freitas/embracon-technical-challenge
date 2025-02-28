import { Flex, IconButton, Input } from "@chakra-ui/react";
import { useState } from "react";
import { FiSearch } from "react-icons/fi";

type Props = {
  onSearch: (value: string) => void;
};

const InputSearch: React.FC<Props> = ({ onSearch }) => {
  const [state, setState] = useState<string>("");

  const handlerSearch = () => {
    onSearch(state);
    setState("");
  };

  return (
    <Flex>
      <Input
        type="text"
        value={state}
        onChange={(e) => setState(e.target.value)}
      />
      <IconButton
        aria-label="Search database"
        icon={<FiSearch />}
        onClick={handlerSearch}
      />
    </Flex>
  );
};

export default InputSearch;
