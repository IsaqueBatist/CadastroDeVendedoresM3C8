import { IGender } from "./gender";

export interface ISeller {
  id: number;
  name: string
  salary: number;
  gender: IGender;
}