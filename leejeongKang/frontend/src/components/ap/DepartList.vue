<template>
    <body>
      <v-container>
      <form>
      <div class="search">
        <h2>진료 예약</h2><br>
      <input class="inputSearch" v-model="keyword" type="text" placeholder="의료진명 또는 진료과를 검색하세요.">
    </div><br><br>
       <v-row justify="center">
        <v-col xs="24" sm="12" md="12">
          <v-card class="pa-3">
            <v-subheader style="dark">Select Doctor</v-subheader>
            <v-divider :inset="false"></v-divider>
              <v-data-table
                            :headers="headers"
                            :items="doctors"
                            :search="keyword"
                            :key="doctors.doctorNo"
                            :items-per-page="5">
                <template v-slot:[`item.doctorName`]="{ item }">
                   <router-link style="color: black" :to="{ name: 'DoctorReadPage',
                                        params: { doctorNo: item.doctorNo } }">
                    {{ item.doctorName }}
                    </router-link>
                </template>
                 <template v-slot:[`item.appointment`]="{ item }">
                   <router-link style="color: blue-" :to="{ name: 'DateAppointmentPage',
                                        params: { doctorNo: item.doctorNo } }">
                    <strong>예약하기</strong>
                    </router-link>
                </template>
              </v-data-table>
          </v-card><br><br><br>
        </v-col>
       </v-row>
    </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: "DepartList",
  props: {
    doctors: {
      type: Array
    }
  },
  data () {
    return {
      headers: [
        { text: '진료과', value: 'major', width: '90px' },
        { text: '이름', value: 'doctorName', width: '230px' },
        { text: '예약', value: 'appointment', width: '20px' }
      ],
      keyword: ''
    }
  }
}
</script>

<style>
.search {
    position: relative;
    text-align: center;
    margin: 0 auto;
}
.inputSearch {
    width: 80%;
    height: 50px;
    border-radius: 20px;
    border: 1px solid #bbb;
    margin: 10px 0;
    padding: 10px 12px;
}
input:focus { outline-color: blue; }
a { text-decoration: none; }
</style>
