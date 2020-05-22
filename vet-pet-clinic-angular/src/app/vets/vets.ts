import {Specialty} from '../specialities/specialty';

export interface Vet {
  id: number;
  firstName: string;
  lastName: string;
  specialties: Specialty[];
}
