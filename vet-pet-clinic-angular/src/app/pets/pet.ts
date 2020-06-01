import {Owner} from '../owners/owner';
import {Visit} from '../visits/visit';
import {PetType} from '../pettypes/pettype';

export interface Pet {
  id: number;
  name: string;
  birthDate: string;
  petType: PetType;
  owner: Owner;
  visits: Visit[];
}
