<template>
    <v-dialog v-model="dialog" max-width="450">
      
        <template v-slot:activator="{ on }">
            <v-btn class="primary white--text mt-5" outlined v-on="on">CHECKOUT</v-btn>
        </template>
      
         <v-card class="rounded-xl pa-4">
          <v-card-title class="headline secondary--text font-weight-bold">
            <p>CHECKOUT</p>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12">
                  <v-text-field label="이름*" v-model="name" :rules="[v => !!v || '이름을 입력하세요.']"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field label="배송지*" v-model="address" :rules="[v => !!v || '배송지를 입력하세요.']"></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-select 
                    :items="['기업은행', '우리은행', '국민은행', '농협은행', '신한은행']"
                    label="무통장입금*"
                    :rules="[v => !!v || '은행명을 선택하세요.']"
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field label="입금자명*" :rules="[v => !!v || '입금자명을 입력하세요.']"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field label="계좌번호*" :rules="[v => !!v || '계좌번호를 입력하세요.']"></v-text-field>
                </v-col>
              </v-row>
            </v-container>
            <small>*은 필수입력 사항입니다.</small>
          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn class="secondary--text font-weight-bold" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn class="secondary--text font-weight-bold" text @click="btnConfirm">
              Confirm
            </v-btn>
          </v-card-actions>
        </v-card>

    </v-dialog>   
</template>

<script>

import { mapState } from 'vuex'

export default {
    data() {
        return {
            dialog: false,
            name: '',
            address: '',

        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    mounted () {
        this.name = this.userInfo.name
        this.address = this.userInfo.address
    },
    methods: {
        btnConfirm() {
            alert("결제가 완료되었습니다.")
        }
    }
}
</script>