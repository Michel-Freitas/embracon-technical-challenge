import { ZipCodeResponse } from "@/module/zipcode/model/ZipCode";
import { ZipCodeLogModel } from "@/module/zipcode/model/ZipCodeLog";
import { useState } from "react";
import zipCodeService from "@/module/zipcode/service/zipCodeService";
import { formatDate } from "@/shared/utils/formatDate";

export const useZipCode = () => {
  const [zipCode, setZipCode] = useState<ZipCodeResponse>();
  const [zipCodeLogList, setZipCodeLogList] = useState<ZipCodeLogModel[]>([]);
  const { getZipCodeByZipCode, getZipCodeLogsByUf } = zipCodeService();

  const searchZipCodeByZipCode = async (zipCode: string) => {
    if (zipCode === "") return;

    const result = await getZipCodeByZipCode(zipCode);
    setZipCode(result.result);
  };

  const searchZipCodeLogsByUf = async (uf: string) => {
    if (uf === "") return;

    const result = await getZipCodeLogsByUf(uf);

    const zipCodeLogList: ZipCodeLogModel[] = result.result.map((item) => {
      return {
        zipCode: item.zipCode,
        dateTimeConsultation: formatDate(item.dateTimeConsultation),
      } as ZipCodeLogModel;
    });

    setZipCodeLogList(zipCodeLogList);
  };

  return {
    zipCode,
    zipCodeLogList,
    searchZipCodeByZipCode,
    searchZipCodeLogsByUf,
  };
};

export default useZipCode;
