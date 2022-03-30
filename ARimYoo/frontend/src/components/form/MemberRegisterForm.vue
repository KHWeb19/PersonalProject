<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <v-row class="formD">
                <v-col class="label" cols="6" >
                    <v-img src="@/assets/form/formId.png" width="100"/> 
                </v-col>
                <v-col wrap cols="12" sm="4">
                <v-text-field solo dense v-model="id"/>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <v-img src="@/assets/form/formPw.png" width="130"/>
                </v-col>
                <v-col  cols="12" sm="4">
                <v-text-field type="password" solo dense v-model="pw"/>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formPw2.png" width="130"/>
                </v-col>
                <v-col cols="12" sm="4">
                <v-text-field type="password" solo dense v-model="pw"/>
                </v-col>
            </v-row>
            <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formName.png" width="100"/>
                </v-col>
                <v-col cols="12" sm="4">
                <v-text-field solo dense v-model="name"/>
                </v-col>
            </v-row>
             <v-row class="formD">
                <v-col class="label" cols="6">
                    <img src="@/assets/form/formBirth.png" width="90"/>
                </v-col>
                <v-col cols="12" sm="4">
                <v-text-field solo type="date" v-model="birth"/>
                </v-col>
            </v-row>
        </form>
        <v-layout row wrap class="mx-auto" >
            <v-flex class="btnSet">
                <router-link to="/main"><v-btn id ="m" color="black" dark>CANCLE</v-btn></router-link> 
                <v-btn type="submit" color="red darken-3" dark>JOIN</v-btn>
             </v-flex>
            
        </v-layout>

    </v-container>

</template>

<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            id: '',
            pw: '',
            name: '',
            birth: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw, name, birth } = this
            this.$emit('submit', { id, pw, name, birth })
        }
    }

}
</script>

<style scoped>
.label {
    position: relative;
    left:20%;
}
.formD {
    margin-top: 5%;

}
input {
    border : 2px solid black;
}
.btnSet{
    padding-top:5%;
    margin-bottom:50px;
    margin-left:13%;
    zoom: 1.2;
}
#m {
    margin-right:56%;
}

</style>>

