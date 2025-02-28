import { ZipCodeLogModel } from "@/module/zipcode/model/ZipCodeLog";
import {
  Table,
  TableContainer,
  Tbody,
  Td,
  Th,
  Thead,
  Tr,
} from "@chakra-ui/react";

type Props = {
  items: ZipCodeLogModel[];
};

const TableZipCodeLog: React.FC<Props> = ({ items }) => {
  return (
    <TableContainer>
      <Table variant="striped" colorScheme="teal">
        <Thead>
          <Tr>
            <Th>#</Th>
            <Th>Cep</Th>
            <Th>Data Consulta</Th>
          </Tr>
        </Thead>
        <Tbody>
          {items.map((item, i) => (
            <Tr key={i}>
              <Td>{i + 1}</Td>
              <Td>{item.zipCode}</Td>
              <Td>{item.dateTimeConsultation}</Td>
            </Tr>
          ))}
        </Tbody>
      </Table>
    </TableContainer>
  );
};

export default TableZipCodeLog;
