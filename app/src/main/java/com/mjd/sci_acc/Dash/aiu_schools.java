package com.mjd.sci_acc.Dash;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mjd.sci_acc.R;

public class aiu_schools extends AppCompatActivity {
    Button SBSS, SCI, SEHS, foundation, LC, moreview;
    TextView text;
    ImageButton backbtn, backBTN;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiu_schools);


        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SBSS = findViewById(R.id.SBSS);
        SEHS = findViewById(R.id.SEHS);
        SCI = findViewById(R.id.SCI);

        foundation = findViewById(R.id.Foundation);
        LC = findViewById(R.id.LC);

        SBSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view_school);
                text = findViewById(R.id.txtSchool);
                text.setText("School of Business & Social Sciences\n" +
                        "The School of Business and Social Sciences (SBSS) upholds AIU’s educational objectives that are grounded in its educational mission that calls for excellence in social business through innovative and creative curriculum and learning experiences. The SBSS programmes develop intellectuals with discipline-specific knowledge combined with practical, real-life social business activities in the field, such as community engagement programmes, surveys, interviews and index mapping of low-income families and business showcases and bootcamps – all of which are underpinned by strong sense of leadership.\n" +
                        "\n" +
                        "Programmes offered\n" +
                        "Bachelor of Business Administration (Hons)\n" +
                        "Bachelor of Business Administration (Hons) (Marketing)\n" +
                        "Bachelor of Business Administration (Hons) (Human Resource   Management)\n" +
                        "Bachelor of Computer Science (Hons)\n" +
                        "\nUpcoming Programmes\n" +
                        "Bachelor of Economics (Hons)\n" +
                        "Bachelor of Social Development (Hons)\n" +
                        "Bachelor of Finance (Islamic Finance) (Hons)\n" +
                        "Master of Science in Business Management \n");
                moreview = findViewById(R.id.Viewbtn);
                moreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_webview_page);
                        webView = findViewById(R.id.confirmpage_webpage);
                        backbtn = findViewById(R.id.backbtn2);
                        backbtn.setVisibility(View.VISIBLE);
                        webView.setWebViewClient(new WebViewClient());
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://www.aiu.edu.my/school-of-business-social-sciences/");
                        Toast.makeText(aiu_schools.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                        backbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                backbtn.setVisibility(View.GONE);
                                finish();
                            }
                        });
                    }
                });
                backBTN = findViewById(R.id.backbtnSchool);
                backBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
        SEHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view_school);
                text = findViewById(R.id.txtSchool);
                text.setText("Schools of Education & Human Sciences\n" +
                        "The School of Education and Human Sciences (SEHS) aims to prepare students to work within the careers of working with children and young people in many sectors, including health, education and social care. Our programmes are technologically-driven, global, and they encapsulate the communication revolution of the 21st Century – powered by the Fourth Industrial Revolution made possible by the advent of Internet 4.0. The SEHS provides an interdisciplinary, multimedia approach to the study of children and elementary education by examining the relationship between theory and practice. The programme focuses on developing students’ ability to absorb technology and professionalism. We strive to create graduates who are competitive, innovative, and creative and meet the demand and ethics required for the corporate world.\n" +
                        "\n" +
                        "\nProgrammes offered\n" +
                        "Bachelor of Elementary Education (Hons)\n" +
                        "Bachelor in Early Childhood Education (Hons)\n" +
                        "Bachelor of Media & Communication (Hons)\n" +
                        "s\nUpcoming Programmes\n" +
                        "Bachelor of Politics & International Relations (Hons) \n");
                moreview = findViewById(R.id.Viewbtn);
                moreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_webview_page);
                        webView = findViewById(R.id.confirmpage_webpage);
                        backbtn = findViewById(R.id.backbtn2);
                        backbtn.setVisibility(View.VISIBLE);
                        webView.setWebViewClient(new WebViewClient());
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://www.aiu.edu.my/school-of-education-human-sciences/");
                        Toast.makeText(aiu_schools.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                        backbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                backbtn.setVisibility(View.GONE);
                                finish();
                            }
                        });

                    }
                });
                backBTN = findViewById(R.id.backbtnSchool);
                backBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
        SCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view_school);
                text = findViewById(R.id.txtSchool);
                text.setText("The School of Computing and Informatics (SCI) aims to produce graduates who are equipped with competitive knowledge, principles, and skills in technical and fundamental computer science theories towards serving the society through social business. SCI aspires to develop adaptable, balanced, well-rounded individuals who are willing and able to serve humanity, acting as change agents in respective communities through its 5A Core Values which are Adab, Akhlak, Amanah, Aqidah, Amalan.  Above all, the Bachelor of Computer Science programme, plus its embedded core values in the curriculum, would produce an individual who is professional, compassionate, empathetic and holistic in all dimensions of life. The graduates of Bachelor of Computer Science from Albukhary International University would stand out as outstanding and exceptional leaders with philanthropic attitudes and traits.\n" +
                        "\n" +
                        "\nVision\n" +
                        "To be the point of reference for computing and informatics in industry and community towards sustainable world\n" +
                        "\n" +
                        "\nMissions\n" +
                        "Produces global computing and informatics experts and professionals to serve humanity\n" +
                        "Produces adaptable, balanced and all-rounded graduates with philanthropic attitudes and traits\n" +
                        "Inculcates integrated minds towards social inclusion globally\n");
                moreview = findViewById(R.id.Viewbtn);
                moreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_webview_page);
                        webView = findViewById(R.id.confirmpage_webpage);
                        backbtn = findViewById(R.id.backbtn2);
                        backbtn.setVisibility(View.VISIBLE);
                        webView.setWebViewClient(new WebViewClient());
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://www.aiu.edu.my/school-of-computing-and-informatics/");
                        Toast.makeText(aiu_schools.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                        backbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                backbtn.setVisibility(View.GONE);
                                finish();
                            }
                        });
                    }
                });
                backBTN = findViewById(R.id.backbtnSchool);
                backBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });

        foundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view_school);
                text = findViewById(R.id.txtSchool);
                text.setText("The Centre for Foundation Studies offers a one-year pre-university programme that enriches students with quality education that imparts the cutting-edge knowledge, skills, and attitudes to undertake undergraduate studies in an international learning and\n" +
                        "teaching environment. Issues of leadership, social responsibility, scholarship, community involvement, ethical values and professionalism are also incorporated into the Centre’s various courses, as well as their approach and delivery. In addition, the Centre has\n" +
                        "established an educational environment where students can broaden their worldview, develop the love for learning, and inculcate the 5As Core Values of Adab, Akhlak, Aqidah, Amanah and Amalan, in line with the Philosophy, Vision and Mission of AIU.\n" +
                        "\n" +
                        "\nProgramme Objectives\n" +
                        "To provide students with quality education that imparts the necessary knowledge, skills, and attitudes to undertake undergraduate studies in an international teaching/learning environment.\n" +
                        "To provide an educational environment where students can broaden their worldview, develop a love for learning, and appreciate universally accepted moral and ethical values as well as humanitarian ideals in line with the Philosophy, Vision and Mission of AIU.");
                moreview = findViewById(R.id.Viewbtn);
                moreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_webview_page);
                        webView = findViewById(R.id.confirmpage_webpage);
                        backbtn = findViewById(R.id.backbtn2);
                        backbtn.setVisibility(View.VISIBLE);
                        webView.setWebViewClient(new WebViewClient());
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://www.aiu.edu.my/centre-for-foundation-studies/");
                        Toast.makeText(aiu_schools.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                        backbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                backbtn.setVisibility(View.GONE);
                                finish();
                            }
                        });
                    }
                });
                backBTN = findViewById(R.id.backbtnSchool);
                backBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
        LC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view_school);
                text = findViewById(R.id.txtSchool);
                text.setText("AIU Language Centre (LC) was established to provide affordable, accessible and high-quality language programmes to learners of different backgrounds and levels.\n" +
                        "\n" +
                        "The main role of LC at AIU is prepare potential students for international English qualification tests such as IELTS or Cambridge Linguaskill. LC also offers language-related services to local schools and institutions of higher learning, lifelong learners and other members of the community.\n" +
                        "\n" +
                        "LC’s experienced and passionate instructors strive to provide engaging learning experiences that are tailored to meet the language needs of any learner. In accordance with the University’s niche area of social business and 5A core values (Adab, Akhlak, Akidah, Amanah & Amalan), AIULC aims to make a mark as the go-to service provider of language learning for the community in the northern region and beyond, and to support learners in their ultimate journey of inspiring minds and serving humanity.\n" +
                        "\n" +
                        "Programmes conducted by LC include:\n" +
                        "\n" +
                        "Preparatory course for International English Language Testing System (IELTS)\n" +
                        "Preparatory course for Cambridge Linguaskill\n" +
                        "General English courses for international and local school-leavers / pre-university students\n" +
                        "Business English / Professional English courses for working adults teacher training courses for local English teachers\n" +
                        "English camps and creative writing programmes during school holidays\n" +
                        "Buddy programmes with local institutions");
                moreview = findViewById(R.id.Viewbtn);
                moreview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_webview_page);
                        webView = findViewById(R.id.confirmpage_webpage);
                        backbtn = findViewById(R.id.backbtn2);
                        backbtn.setVisibility(View.VISIBLE);
                        webView.setWebViewClient(new WebViewClient());
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.loadUrl("https://www.aiu.edu.my/language-centre/");
                        Toast.makeText(aiu_schools.this, "Loading.. ⭐ Please Wait ⌛", Toast.LENGTH_LONG).show();
                        backbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                backbtn.setVisibility(View.GONE);
                                finish();
                            }
                        });
                    }
                });
                backBTN = findViewById(R.id.backbtnSchool);
                backBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
    }
}