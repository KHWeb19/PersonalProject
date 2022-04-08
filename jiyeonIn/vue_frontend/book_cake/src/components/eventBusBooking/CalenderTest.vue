<template>
    <div class="celander">
        <v-container>
          <v-row>
            <v-col cols="4" >
              <v-menu
                ref="menu1"
                v-model="menu1"
                :close-on-content-click="false"
                transition="scale-transition"
                offset-y
                max-width="290px"
                min-width="auto"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-text-field
                    v-model="dateFormatted"
                    label="Date"
                    hint="MM/DD/YYYY format"
                    persistent-hint
                    prepend-icon="mdi-calendar"
                    v-bind="attrs"
                    @blur="date = parseDate(dateFormatted)"
                    v-on="on"
                  ></v-text-field>
                </template>
                <v-date-picker
                  v-model="date"
                  no-title
                  @input="menu1 = false"
                ></v-date-picker>
              </v-menu>
              
            </v-col>
            <v-col cols="4">
              <v-text-field class="time" v-model="time" placeholder="시간 입력 (09~19시)"></v-text-field>
            </v-col>
            
            <v-col>
              <v-btn color="black" text type="button" v-on:click="calendarInform" v-model="isShow" >
                <v-icon color="black" text >mdi-check</v-icon>확정
              </v-btn>
            </v-col>
          </v-row>
      
      
          <div v-show="isShow" style="font-size: 14px;"><br><p>선택한 날짜 & 시간 : <strong>{{ date }} & {{ time }} </strong>  </p></div>
        </v-container>
        
        
  </div>
</template>

<script>

  export default {
    data: vm => ({
      date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
      dateFormatted: vm.formatDate((new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)),
      menu1: false,
      menu2: false,
      time: '',
      isShow: false,
    }),

    computed: {
      computedDateFormatted () {
        return this.formatDate(this.date)
      },
    },

    watch: {
      date () {
        this.dateFormatted = this.formatDate(this.date)
        
      },
    },

    methods: {
      formatDate (date) {
        if (!date) return null

        const [year, month, day] = date.split('-')
        return `${month}/${day}/${year}`
      },
      parseDate (date) {
        if (!date) return null

        const [month, day, year] = date.split('/')
        return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
      },
      calendarInform() {
        const { date, time } =this
        this.$emit('submit', { date, time })
        this.isShow = !this.isShow
      }
    }

  }
</script>

<style scoped>

</style>