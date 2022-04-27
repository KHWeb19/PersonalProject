<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <label>Username</label>
            </v-col>
            <v-col cols="12">
                <input type="text" v-model.lazy="username" placeholder="Username" @blur="v$.username.$touch">
                <p v-if="v$.username.$errors.length" class="red--text">{{v$.username.$errors[0].$message}}</p>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
import useVulidate from '@vuelidate/core'
import {required, helpers, minLength} from '@vuelidate/validators'

const isUsernameTaken = (value) => axios.get('userunique', {params: {username: value}}).then(res => {return res.data})

export default{
    setup(){
        return {
            v$: useVulidate()
        }
    },

    data(){
        return {
            username: ''
        }
    },
    validations(){
        return{
            username: {
                required,
                minLength: minLength(4),
                isUserUnique: helpers.withMessage('Username taken', helpers.withAsync(isUsernameTaken))
            }
        }
    }
}
</script>