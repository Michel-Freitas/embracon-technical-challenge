export type BaseResponse<T> = {
  result: T;
  message: string;
  success: boolean;
};
