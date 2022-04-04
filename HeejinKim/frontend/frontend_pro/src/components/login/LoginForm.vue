<template>
    <div>
    <!--
   <v-dialog v-model="login_dialog" max-width="350">
        <template v-slot:activator="{ on, attrs }"> </template> </v-dialog>-->
            <v-btn text color="black" class="btn-flat" v-on="on" v-bind="attrs">
                Login
            </v-btn>
        
        <v-card>
            <v-container >
                <form @submit.prevent="onSubmit">
                    
                    <v-card class="card_box">
                        <h1 class="text-center"> Hello </h1>
                        <div class="input" justify-center>
                            
                            <div class="input_area">
                            <v-text-field class="pl-4 pr-4" flat solo v-model="userId" type="text" label="userId" :rules="rulesId"> 
                            </v-text-field></div>

                            <div class="input_area">
                            <v-text-field class="pl-4 pr-4" flat solo v-model="password" type="password" label="password"
                            :rules="rulesPassword"> </v-text-field></div>
                            
                            <div class="row">
                                <v-radio-group v-model="radioGroup" row>
                                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`" :value="kinds"></v-radio>
                                </v-radio-group>
                            </div>

                            <div class="forgot_pw pt-5 " >
                                <h5> FORGOT PASSWORD?</h5>
                            </div>

                            <div class="btn-size pt-2">
                                <v-btn width="200" height="50px" type="submit" color="black" style="margin-top:10%;"
                                class="white--text" rounded >
                                    login
                                </v-btn>
                            </div>
                        </div>
                    </v-card>
                </form>
            </v-container>
        </v-card>
   </div>
    
</template>

<script>

export default {
    data () {
        return {
                      
            userId: '',
            password: '',
            
            radioGroup: 1,
                kindsOfMember: [
                    'user',
                    'manager'
                ],
            rulesId:[
                    v => !!v || 'Enter your id'
            ],
            rulesPassword:[
                    v => !!v || 'Enter your password',
                    v => v.length >= 3 || 'Password must be less than 3 characters'     
            ],
    

        }
    },
    methods:{
        onSubmit  () {
            const { userId, password } = this
            this.$emit('submit', { userId, password })
        }

    }
}

</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');

.theme--light.v-card {
    background-color:#f3f3f3;
}

.card_box{
   
    height: 550px;
    text-align: center;
    position: relative;
    display: center;
    padding: 5% 0% 30% 0%;
    width: 500px;
    
}

.card_box h1{

    font-family: 'Poiret One', cursive;
    font-size: 50px;
    margin-top: 30px;
    color: black;
    text-align: center;
    
}
.input{
    
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 50px;  

}
.v-input{  
    font-size: 20px;
}

/* 입력칸 배경색
.theme--light.v-text-field--solo > .v-input__control > .v-input__slot {
    background: #583d3d;
}*/





</style>
