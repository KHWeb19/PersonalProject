<template>
  <v-row>
    <v-col>
      <v-btn fab class="float-right">
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" fab>
              <v-icon x-large>mdi-lead-pencil</v-icon>
            </v-btn>
          </template>

          <v-list dense>
            <v-list-item-group>
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title @click="showDialog">일정</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-menu>
      </v-btn>

      <v-dialog max-width="500" v-model="makePlan">
        <v-card>
          <v-card-title>
            <span class="text-h5">User Profile</span>
          </v-card-title>

          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6" md="4" align-self="center" >
                  여행 이름
                </v-col>

                <v-col cols="12">
                  <v-text-field label="make trip name!"></v-text-field>
                </v-col>

                <v-col cols="6" sm="6" md="6">
                  출발하는 날
                </v-col>
                <v-col cols="6" sm="6" md="6">
                  마지막 날
                </v-col>

                <v-col cols="6">
                  <v-text-field label="Start Day" required></v-text-field>
                </v-col>
                <v-col cols="6">
                  <v-text-field label="End Day" required></v-text-field>
                </v-col>

                <v-col cols="12" sm="6" md="4" align-self="center" >
                  여행 장소
                </v-col>

                <v-col cols="12">
                  <v-text-field label="Trip Place" hint="example of helper text only on focus"></v-text-field>
                </v-col>

              </v-row>
            </v-container>
            <small>여행 계획을 작성해봐요</small>
          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="makePlan = false">Close</v-btn>
            <v-btn color="green darken-1" text @click="makePlan = false">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "BeforePencilIcon",
  data() {
    return{
      dropItems: [
        {text: '일정생성', icon: 'mdi-clock'},
        {text: '친구초대', icon: 'mdi-clock'}
      ],
      makePlan: false,
    }
  },
  methods: {
    testOne(item) {
      if(item === '일정생성'){
        alert('일정생성');
      }else if(item === '친구초대'){
        alert('친구초대')
      }
    },
    showDialog() {
      this.makePlan = true
    }

  }
}
</script>

<style scoped>

</style>