package app.bestjokes.af;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class Rec_view extends AppCompatActivity {

    RecyclerView recycler_view1;
    LinearLayoutManager layoutManager;

    String titles[] = {"ګریه عروسی","خواهر لیلی","روز امتحان","چت انترنیتی","پول اش را پدر میته","کمنت های افغان ها","دیوانه و دوکاندار"};
    String jokes[] = {"یک طفل بعد از محفل عروسی از مادرش میپرسه مادر چرا عروس ګریه میکنه و دادماد نمی کنه مادرش به طفلش میګه عروس تا دهن دروازه ګریه میکنه اما دادماد تا دهن قبر","کسی از مجنون میپرسه اګر به لیلی نرسی چه میکنی؟ ګفت خواهر لیلی لیلما را میګیرم","استاد به شاګردان میګه انسان کسی است که به درد دګرها بخوره یکی از شاګرد ها میګه استاد در روز امتحان نی شما انسان میشوید نی دګرها را به انسان شدن میمانید","هشتاد وپنج فیصد ازدواج ها در اروپا انترنیتی است اما در افغانستان شش ماه بعد معلوم میشه که بنفشه خیر محمد بوده","یک روز یک محصل به پدرش زنګ میزنه میګه پدر مه در پوهنتون چانس خوردم، پدرش میګه هر چی میخوری بچیم بخور پول اش را مه میتم","لقمان حکیم را پرسیدند عقل را از که اموختی؟ ګفت:از کمنت های افغان ها","یک نفر با پسرش میره میوه خریدن در هنګام میوه خریدن پسر هر لحظه یک کیله را پوست کده میخوره دکاندار قهر میشه میګه او بچه چه میکنی پدرش میګه خیره بانش دیوونه است دکاندار میګه خیر که دیوانه است چرا این پیاز ها را نمیخوره"};

    jokes_adapter recadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);
        recycler_view1 = findViewById(R.id.recycler_view);
        recadapter = new jokes_adapter(titles,jokes);

        Log.d("message", "onCreate: "+titles.length+""+jokes.length);

        layoutManager = new LinearLayoutManager(Rec_view.this,LinearLayoutManager.VERTICAL,false);
        recycler_view1.setLayoutManager(layoutManager);
        recycler_view1.setAdapter(recadapter);

    }
}
