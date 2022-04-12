import {
    FETCH_USER_PLANS
} from './mutation-types'

export default {
    [FETCH_USER_PLANS] (state, plan){
        state.userPlans = plan
    }
}