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

      <v-dialog max-width="800" v-model="makePlan">
        <v-card>
          <v-card-title>
            <span style="font-size: 40px; color: darkolivegreen"><br/>여행 계획을 작성해보아요! </span>
          </v-card-title>

          <v-card-text>
            <v-container>
              <form @submit="onSubmit">
                <table>
                  <tr>
                    <td colspan="2" class="plan">여행 이름</td>
                  </tr>

                  <tr>
                    <td colspan="2">&nbsp;&nbsp;<input class="inputBox" type="text" placeholder="make trip name!" v-model="planName" required></td>
                  </tr>
                  <tr></tr>
                  <tr>
                    <td class="plan"> 여행 일정 </td>
                    <td> <v-btn @click="showDatePicker" fab><v-icon x-large>mdi-calendar-multiselect</v-icon></v-btn> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td> <input type="text" readonly v-model="planDate" placeholder="range date" required></td>
                  </tr>
                  <tr></tr>
                  <tr></tr>
                  <tr>
                    <td colspan="2" class="plan">여행 장소</td>
                  </tr>

                  <tr>
                    <td colspan="2">&nbsp;&nbsp;<input type="text" class="inputBox" placeholder="trip place!" v-model="placeName" required></td>
                  </tr>

                </table>
              </form>

              <v-dialog max-width="400" v-model="pickDate" light>
                <v-date-picker v-model="dates" range></v-date-picker>
              </v-dialog>

            </v-container>

          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="makePlan = false">Close</v-btn>
            <v-btn @click="onSubmit" color="green darken-1">Save</v-btn>
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
        {text: '친구초대', icon: 'mdi-clock'},
        {text: '투표만들기', icon: 'mdi-clock'}
      ],
      makePlan: false,
      pickDate: false,
      dates: ['', ''],
      planName: '',
      placeName: ''
    }
  },
  props:{
    id: {
      type: String
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
    },
    showDatePicker(){
      this.pickDate = true
    },
    onSubmit(){
      const {planName, planDate, placeName} = this;

      console.log({planName, planDate, placeName});
      this.makePlan = false;
      this.$emit('submit',{planName, planDate, placeName});
    }
  },
  computed: {
    planDate () {
      return this.dates.join(' ~ ')
    },
  },
}
</script>

<style scoped>
table {
  border-collapse:  separate;
  border-spacing: 0 1rem;
}
.plan{
  font-size: 30px;
}
input{
  font-size: 20px;
}
/*td{
  border: 1px solid black;
  font-size: 20px;
}*/

</style>