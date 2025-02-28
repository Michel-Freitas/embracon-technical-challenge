import webApi from "@/config/axios";
import { ZipCodeResponse } from "@/module/zipcode/model/ZipCode";
import { ZipCodeLogResponse } from "@/module/zipcode/model/ZipCodeLog";
import { BaseResponse } from "@/shared/response/baseResponse";

const zipCodeService = () => {
  const getZipCodeByZipCode = async (
    zipCode: string
  ): Promise<BaseResponse<ZipCodeResponse>> => {
    const { data } = await webApi.get(`zipcode/${zipCode}`);

    return data;
  };

  const getZipCodeLogsByUf = async (
    uf: string
  ): Promise<BaseResponse<ZipCodeLogResponse[]>> => {
    const { data } = await webApi.get(`zipcode/list-logs?uf=${uf}`);

    return data;
  };

  return { getZipCodeByZipCode, getZipCodeLogsByUf };
};

export default zipCodeService;
