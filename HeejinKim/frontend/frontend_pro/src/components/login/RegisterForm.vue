<template>
    <v-container class="SignUpForm" style="height:100%">
        <form @submit.prevent="onSubmit">
            <h3 class="text-center"> Create account </h3>
            <div justify-center>

                <v-text-field class="pl-4 pr-4" flat solo v-model="userId" type="text" label="userId"
                prepend-icon="mid-account" > </v-text-field>

                <v-text-field class="pl-4 pr-4" flat solo v-model="password" type="password" label="password"
                prepend-icon="mid-lock" > </v-text-field>

                <v-text-field class="pl-4 pr-4" flat solo v-model="passwordCheck" type="password" label="passwordCheck"
                prepend-icon="mid-account" > </v-text-field>

                <v-text-field class="pl-4 pr-4" flat solo v-model="email" type="text" label="email"
                prepend-icon="mid-email-multiple" > </v-text-field>

                <div class="row">
                    <v-radio-group v-model="radioGroup" row>
                        <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`" :value="kinds"></v-radio>
                    </v-radio-group>
                </div>


                <div class="btn-size">
                    <v-btn width="300" height="50" type="submit" color="black" style="float:left; margin-top:6%;"
                    class="white--text" rounded>
                    SIGN UP
                    </v-btn>
                </div>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'RegisterForm',

        data(){
            return {
                userId : '',
                password: '',
                passwordCheck : '',
                email : '',
                radioGroup: 1,
                kindsOfMember: [
                    '개인',
                    '사업자'
                ]
            }
        },
    methods: {
        onSubmit () {
            const {  userId, password, passwordCheck, email, radioGroup } = this
            const auth = (radioGroup == '개인' ? '개인' : '사업자')
            this.$emit('submit', { userId, password, passwordCheck, email, auth})

        }
    }
}
</script>