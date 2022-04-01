<template>
    <v-sheet>
    
        <v-dialog v-model="loginDialog" persisten max-width="400px">
            <template v-slot:activator="{ on }">
                <v-btn v-on="on" icon class="float-right">lock_open</v-btn>
            </template>

            <v-card>
                <v-card-title class="headline">
                    <span>
                        로그인
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field label="Email" v-model="userInfo.email" required solo>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="비밀번호 입력해!" v-model="userInfo.password" required solo>
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        로그인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-sheet>
    
</template>

<script>

export default {
    data () {
        return {
            loginDialog: false,
            userInfo: {
                email: '',
                password: ''
            }

        }
    },
    methods:{

    }
}

</script>